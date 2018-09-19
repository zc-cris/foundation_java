package day14;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Test03
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test03 {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        Scanner scanner = new Scanner(System.in);

        /// 用户登录
        /*System.out.println("请输入用户名：");
        String name = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();
        User login = userService.login(name, password);
        System.out.println(login == null ? "登录失败！" : "登录成功，你的信息是：" + login);
        */

        System.out.println("请输入用户名：" );
        String name = scanner.next();
        boolean register = userService.register(name);
        if (!register) {
            // 
        }else {
            System.out.println("注册失败！已经有同名用户了" );
        }


    }
}

interface UserService {
    User login(String name, String password);

    boolean register(String name);
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
class User {
    private String name;
    private String password;
    private String mail;
    private String tel;
}

@Data
@NoArgsConstructor
@Accessors(chain = true)
class UserServiceImpl implements UserService {

    private static List<User> users = new ArrayList<>(){
        {
            add(new User("cris","123","qq@com","343"));
            add(new User("james","321","geg@com","9080"));
            add(new User("zc","111","ppn@com","493"));
        }
    };

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        UserServiceImpl.users = users;
    }

    @Override
    public User login(String name, String password) {
        for (User user : users) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean register(String name) {
        for (User user1 : users) {
            if (user1.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}