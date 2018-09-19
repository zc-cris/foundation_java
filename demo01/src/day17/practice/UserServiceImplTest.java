package day17.practice;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author zc-cris
 */
public class UserServiceImplTest {

    private UserService userService;


    @Before
    public void testBefore() {
        userService = new UserServiceImpl();
        userService.add(new User("cris", "434", "343"));
    }

    @Test
    public void add() {

        try {

            userService.add(new User("cris", "434", "343"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        List<User> users = ((UserServiceImpl) userService).getUsers();
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void login() {

        userService.add(new User("cris", "434", "343"));

        User cris = null;
        try {
            cris = userService.login("ddd", "434");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("cris = " + cris);
    }
}