package online.tuanzi.onlineedu.constants;

/**
 * @author Tuanzi
 * @Description: Redis常量类，单位：毫秒
 */
public class RedisConstants {
    public static final String LOGIN_CODE_KEY = "login:code:";
    public static final Long LOGIN_CODE_TTL = 5 * 60 * 1000L;//5分钟
    public static final String LOGIN_USER_KEY = "login:token:";
    public static final Long LOGIN_USER_TTL = 24 * 60 * 60 * 1000L;//1天
    public static final Long CACHE_NULL_TTL = 2 * 60 * 1000L;//2分钟
}