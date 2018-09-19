package day17.practice;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class UserNameNotExistException extends RuntimeException {
    public UserNameNotExistException() {
    }

    public UserNameNotExistException(String message) {
        super(message);
    }
}
