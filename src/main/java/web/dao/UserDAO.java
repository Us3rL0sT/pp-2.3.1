package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    void addUser(User user);
    void updateUser(User user);
    void removeUser(int id);

    User getUserById(int id);


}



















