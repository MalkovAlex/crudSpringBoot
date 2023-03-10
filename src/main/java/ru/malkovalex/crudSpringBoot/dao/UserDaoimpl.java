package ru.malkovalex.crudSpringBoot.dao;

import org.springframework.stereotype.Repository;
import ru.malkovalex.crudSpringBoot.model.User;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoimpl implements UserDao {

    private final EntityManager entityManager;

    public UserDaoimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void createUser(User user) {
        entityManager.joinTransaction();
        entityManager.persist(user);
    }


    @Override
    public User getUser(Long id) {
        TypedQuery<User> query = entityManager.createQuery("from User where id=:id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<User> getList() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public void updateUser(Long id, User user) {
        entityManager.joinTransaction();
        User u = getUser(id);
        u.setName(user.getName());
        u.setLastName(user.getLastName());
        u.setEmail(user.getEmail());
        entityManager.persist(u);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.joinTransaction();
        try {
            entityManager.remove(getUser(id));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    public void deleteUser(User user) {
        entityManager.joinTransaction();
        findUser(user).forEach(u -> entityManager.remove(u.getId()));
    }

    @Override
    public List<User> findUser(User user) {
        TypedQuery<User> query = entityManager.createQuery("from User where name=:nm and lastName=:lnm and email=:eml", User.class);
        query.setParameter("nm", user.getName());
        query.setParameter("lnm", user.getLastName());
        query.setParameter("eml", user.getEmail());
        return query.getResultList();
    }
}
