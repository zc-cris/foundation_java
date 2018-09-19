package day17.teammanager.service;

/**
 * 自定义团队异常类
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings({"unused", "WeakerAccess"})
public class TeamException extends Exception {

    public TeamException() {

    }

    public TeamException(String message) {
        super(message);
    }
}
