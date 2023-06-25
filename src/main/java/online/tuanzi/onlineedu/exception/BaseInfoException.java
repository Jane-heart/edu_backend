package online.tuanzi.onlineedu.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;
import online.tuanzi.onlineedu.enums.ResultCode;

/**
 * @author Tuanzi
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseInfoException extends RuntimeException{
    private final ResultCode resultCode;


    public BaseInfoException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

}
