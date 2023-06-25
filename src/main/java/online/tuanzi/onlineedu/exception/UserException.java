package online.tuanzi.onlineedu.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;
import online.tuanzi.onlineedu.enums.ResultCode;

/**
 * @author Tuanzi
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserException extends RuntimeException {
    private final ResultCode resultCode;


    public UserException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
