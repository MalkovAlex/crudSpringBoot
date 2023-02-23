package ru.malkovalex.crudSpringBoot.dao;



import ru.malkovalex.crudSpringBoot.model.User;

import java.util.List;

public interface UserDao {
    void createUser(User user);

    User getUser(Long id);

    List<User> getList();

    void updateUser(Long id, User user);

    void deleteUser(Long id);

    void deleteUser(User user);

    List<User> findUser(User user);

}
