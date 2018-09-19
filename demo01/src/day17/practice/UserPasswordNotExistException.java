package day17.practice;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class UserPasswordNotExistException extends RuntimeException {
    public UserPasswordNotExistException() {
    }

    public UserPasswordNotExistException(String message) {
        super(message);
    }
}
