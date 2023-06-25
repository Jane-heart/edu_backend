package online.tuanzi.onlineedu.common;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Redis数据实体
 */
@Data
public class RedisData {
    private LocalDateTime expireTime;
    private Object data;
}
