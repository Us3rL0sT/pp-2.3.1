package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
//    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public void addUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUser(int id) {
        User user = getUserByID(id);
        entityManager.remove(user);
    }

    @Override
    public User getUserByID(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
//    @Transactional
    public List<User> getAllUsers(){ /** в этом методе возникает ошибка: org.springframework.web.util.NestedServletException: Request processing failed; nested exception is java.lang.NullPointerException: Cannot invoke "javax.persistence.EntityManager.createQuery(String, java.lang.Class)" because "this.entityManager" is null
        что тут не так, я не могу понять **/
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }
}












































