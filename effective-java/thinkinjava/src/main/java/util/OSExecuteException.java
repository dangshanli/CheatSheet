package util;

/**
 * 自定义异常
 */
public class OSExecuteException extends RuntimeException {
    public OSExecuteException(String why){
        super(why);
    }
}
