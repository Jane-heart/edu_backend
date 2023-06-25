package online.tuanzi.onlineedu.interceptor;


import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import online.tuanzi.onlineedu.anno.NoNeedLogin;
import online.tuanzi.onlineedu.common.RedisData;
import online.tuanzi.onlineedu.enums.ResultCode;
import online.tuanzi.onlineedu.exception.UserLoginException;
import online.tuanzi.onlineedu.model.entity.User;
import online.tuanzi.onlineedu.service.UserService;
import online.tuanzi.onlineedu.utils.AccountHolder;
import online.tuanzi.onlineedu.utils.CacheClient;
import online.tuanzi.onlineedu.utils.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

import static online.tuanzi.onlineedu.constants.RedisConstants.LOGIN_USER_KEY;
import static online.tuanzi.onlineedu.constants.RedisConstants.LOGIN_USER_TTL;


@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Resource
    private UserService userService;

    @Resource
    private CacheClient cacheClient;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("LoginInterceptor已拦截");
        //是不是映射到方法上
        boolean isHandlerMethod = handler instanceof HandlerMethod;
        if (!isHandlerMethod) {
            return true;
        }
        //不需要登录的注解
        boolean isNoNeedLogin = ((HandlerMethod) handler).getMethodAnnotation(NoNeedLogin.class) != null;
        if (isNoNeedLogin) {
            log.info("当前方法:{}无需登录", ((HandlerMethod) handler).getMethod().getName());
            return true;
        }

//        ((HandlerMethod) handler).getMethodAnnotation(BasicErrorController.class)!=null;
        //需要登录验证
        String token = request.getHeader("token");

        if (StringUtils.hasText(token)) {
            // 此处做token及其身份验证
            return verifyToken(token);

        }

        throw new UserLoginException(ResultCode.USER_TOKEN_IS_BLANK);
    }

    /**
     * 使用token进行身份验证
     *
     * @param token
     * @return
     */
    private Boolean verifyToken(String token) {
//        if (!"token".equals(token)) {
//            throw new UserLoginException(ResultCode.USER_TOKEN_IS_INVALID);
//        }
//        log.info("成功");
        Claims claims = null;
        try {
            claims = TokenUtil.parseJwt(token);
        } catch (Exception e) {
            log.info("token有误,当前claims为：{}", claims);
            throw new UserLoginException(ResultCode.USER_TOKEN_IS_INVALID);
        }
        //验证逻辑
        if (null != claims) {
            Integer id = Integer.valueOf(claims.getId());

            User user = userService.getById(id);
            //查询redis中是否存在对应的token
            log.info("查询redis中是否存在对应的token");
            String redisToken = String.valueOf(cacheClient.queryWithPassThrough(LOGIN_USER_KEY, user.getEmail(),
                    RedisData.class, s -> null, LOGIN_USER_TTL, TimeUnit.SECONDS).getData());
            //查询token是否存在且相等，则将user保存到本地线程
            if (StringUtils.hasLength(redisToken) && redisToken.equals(token) && user != null) {
                // 将用户放在threadLocal中
                log.info("用户已放入threadLocal中");
                AccountHolder.saveUser(user);
                return true;
            }else {
                //用户token与redis中不匹配
                throw new UserLoginException(ResultCode.USER_TOKEN_IS_INVALID);
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //响应结束 threadLocal移除对象
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        AccountHolder.removeUser();//移除对象
    }

}