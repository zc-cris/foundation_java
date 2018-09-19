package day17.practice;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public interface UserService {
    boolean add(User user);

    User login(String name, String password);
}
