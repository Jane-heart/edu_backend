package online.tuanzi.onlineedu.advice;


import lombok.extern.slf4j.Slf4j;
import online.tuanzi.onlineedu.common.Result;
import online.tuanzi.onlineedu.enums.ResultCode;
import online.tuanzi.onlineedu.exception.BaseInfoException;
import online.tuanzi.onlineedu.exception.RedisException;
import online.tuanzi.onlineedu.exception.UserException;
import online.tuanzi.onlineedu.exception.UserLoginException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Tuanzi
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
// TODO: 2023/2/23  补充异常（已完成大部分）

    //用户登录异常拦截
    @ExceptionHandler(UserLoginException.class)
    public Result userLoginExceptionHandler(HttpServletRequest req, UserLoginException e) {
        log.error("出现UserLoginException异常：",e);
        return Result.failure(e.getResultCode());
    }

    //用户异常拦截
    @ExceptionHandler(UserException.class)
    public Result userExceptionHandler(HttpServletRequest req, UserException e) {
        log.error("出现UserException异常：", e);
        return Result.failure(e.getResultCode());
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    public Result internalExceptionHandler(HttpServletRequest req, NullPointerException e) {
        log.error("出现NullPointerException异常：",e);
        return Result.failure(ResultCode.PARAM_IS_BLANK);
    }

    //参数转换异常拦截
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result paramExceptionHandler(HttpServletRequest req, HttpMessageNotReadableException e) {
        log.error("出现HttpMessageNotReadableException异常：",e);
        return Result.failure(ResultCode.SYSTEM_ERROR);
    }

    //参数异常拦截，-1为系统异常
    @ExceptionHandler(BaseInfoException.class)
    public Result baseInfoExceptionHandler(HttpServletRequest req, BaseInfoException e) {
        log.error("出现BaseInfoException异常：",e);
        return Result.failure(e.getResultCode());
    }

    //redis异常拦截
    @ExceptionHandler(RedisException.class)
    public Result redisExceptionHandler(HttpServletRequest req, RedisException e) {
        log.error("出现RedisException异常：",e);
        return Result.failure(e.getResultCode());
    }

    //其他异常拦截
    @ExceptionHandler(Exception.class)
    public Result internalExceptionHandler(HttpServletRequest request, Exception e) {
        log.error("出现Exception异常：",e);
        return Result.failure(ResultCode.INTERNAL_ERROR);
    }
}
