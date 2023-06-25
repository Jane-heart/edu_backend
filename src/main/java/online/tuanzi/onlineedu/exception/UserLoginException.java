package online.tuanzi.onlineedu.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;
import online.tuanzi.onlineedu.enums.ResultCode;

/**
 * @author Tuanzi
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserLoginException extends RuntimeException{
    private final ResultCode resultCode;


    public UserLoginException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

}