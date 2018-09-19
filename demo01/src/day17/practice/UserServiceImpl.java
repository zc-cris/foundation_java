package day17.practice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();
    private int count;
    private int maxCount = 2;

    @Override
    public boolean add(User user) throws RuntimeException{
        if (count > maxCount) {
            throw new RuntimeException("容量已满");
        }
        for (User user1 : users) {
            if (user1.getName().equals(user.getName())) {
                throw new RuntimeException("用户名已经存在");
            }
        }
        users.add(user);
        ++count;
        return true;
    }

    @Override
    public User login(String name, String password) throws UserNameNotExistException, UserPasswordNotExistException{
        User user = null;
        if (name == null || "".equals(name.trim())) {
            throw new UserNameNotExistException("用户名不能为空");
        }
        if (password == null || "".equals(password.trim())) {
            throw new UserPasswordNotExistException("用戶密码不能为空");
        }
        for (User user1 : users) {
            if (user1.getName().equals(name)) {
                user = user1;
            }
        }
        if (user == null) {
                        throw new RuntimeException("用户不存在");
        }
        return user;
    }
}
