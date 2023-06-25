package online.tuanzi.onlineedu.utils;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import online.tuanzi.onlineedu.common.RedisData;
import online.tuanzi.onlineedu.enums.ResultCode;
import online.tuanzi.onlineedu.exception.RedisException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static online.tuanzi.onlineedu.constants.RedisConstants.CACHE_NULL_TTL;


@Slf4j
@Component
public class CacheClient {

    private final StringRedisTemplate stringRedisTemplate;

    private static final ExecutorService CACHE_REBUILD_EXECUTOR = Executors.newFixedThreadPool(10);

    public CacheClient(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public void set(String key, Object value, Long time, TimeUnit unit) {
        stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(value), time, unit);
    }

    /**
     * 判断 key 是否存在
     *
     * @param key 键
     * @return 如果存在 key 则返回 true，否则返回 false
     */
    public Boolean hasKey(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    //将任意Java对象序列化为json并存储在string类型的key中，并且可以设置TTL过期时间
    public void setWithLogicalExpire(String key, Object value, Long time, TimeUnit unit) {
        // 设置逻辑过期
        RedisData redisData = new RedisData();
        redisData.setData(value);
        redisData.setExpireTime(LocalDateTime.now().plusSeconds(unit.toSeconds(time)));
        // 写入Redis
        stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(redisData));
    }

    /**
     * 向list的末尾插入一条数据
     *
     * @param key   键
     * @param value 值
     */
    public Long listRightPush(String key, String value) {
        return stringRedisTemplate.opsForList().rightPush(key, value);
    }

    /**
     * 向list末尾添加list数据
     *
     * @param key   键
     * @param value 值
     */
    public Long listRightPushAll(String key, List<String> value) {
        return stringRedisTemplate.opsForList().rightPushAll(key, value);
    }

    /**
     * 通过索引获取list中的元素
     *
     * @param key   键
     * @param index 索引（index>=0时，0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推）
     * @return 列表中的元素
     */
    public Object listIndex(String key, long index) {
        return stringRedisTemplate.opsForList().index(key, index);
    }

    /**
     *
     */
    public <R,ID> R queryWithPassThrough(
            String keyPrefix, ID id, Class<R> type, Function<ID, R> dbFallback, Long time, TimeUnit unit){
        String key = keyPrefix + id;
        // 1.从redis查询缓存
        String json = stringRedisTemplate.opsForValue().get(key);
        // 2.判断是否存在
        if (CharSequenceUtil.isNotBlank(json)) {
            // 3.存在，直接返回
            return JSONUtil.toBean(json, type);
        }
        // 判断命中的是否是空值
        if (json != null) {
            // 返回一个错误信息
            log.error(ResultCode.USER_TOKEN_IS_INVALID.getMessage());
            throw new RedisException(ResultCode.USER_TOKEN_IS_INVALID);
        }

        // 4.不存在，根据id查询数据库
        R r = dbFallback.apply(id);
        // 5.不存在，返回错误
        if (r == null) {
            // 将空值写入redis
            stringRedisTemplate.opsForValue().set(key, "", CACHE_NULL_TTL, TimeUnit.MICROSECONDS);
            // 返回错误信息
            log.error(ResultCode.USER_TOKEN_IS_INVALID.getMessage());
            throw new RedisException(ResultCode.USER_TOKEN_IS_INVALID);
        }
        // 6.存在，写入redis
        this.set(key, r, time, unit);
        return r;
    }
}