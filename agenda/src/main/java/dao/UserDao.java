package dao;

import model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/19.
 */
public class UserDao {
    private List<User> users;
    private static final UserDao userDao = new UserDao();

    private UserDao() {
    }

    public static UserDao getInstance() {
        return userDao;
    }

    public void init(List<User> users) {

        this.users = users;
    }

    public List<User> getList() {
        return users;
    }

    public User findByName(String name) {
        for (User user : users) {
            if (user.getUserName().equals(name)) return user;
        }
        return null;
    }

    public boolean addUser(User user) {
        users.add(user);
        return true;
    }

    public boolean deleteUser(String userName) {
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }

    public List<User> findAll() {
        return users;
    }
}
