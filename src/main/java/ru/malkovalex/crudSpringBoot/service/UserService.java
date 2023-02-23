package ru.malkovalex.crudSpringBoot.service;

import ru.malkovalex.crudSpringBoot.model.User;
import ru.malkovalex.crudSpringBoot.model.User;

import java.util.List;

public interface UserService {


    User getUser(Long id);

    List<User> getList();

    void updateUser(Long id, User user);

    void createUser(User user);

    void deleteUser(Long id);

    void deleteUser(User user);

    List<User> findUser(User user);
}
