package web.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


//    private ArrayList<User> users;
//
//    {
//        users = new ArrayList<>();
//
//        users.add(new User(0L, "Dmitriy", "Oboev", "22.02.2002", "dimaxof@mail.ru"));
//    }
//    @Override
//    public List<User> getUsers() {
//        return users;
//    }
//
//    @Override
//    public List<User> getUsersByID(int count) {
//        return users.stream().limit(count).collect(Collectors.toList());
////        ArrayList<User> countCars = new ArrayList<>();
////        if (count >= users.size()) {
////            return users;
////        } else {
////            for (int i = 1; i <= count; i++) {
////                countCars.add(users.get(i));
////            }
////            return countCars;
////        }
//    }
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserByID(int id) {
        return userDAO.getUserByID(id);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        userDAO.removeUser(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }


}





























