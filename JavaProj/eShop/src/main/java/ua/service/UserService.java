package ua.service;

import java.util.List;

import ua.entity.User;

public interface UserService {

    void save(User user);

    User findByUserFullName(String userFullName);

    void deleteByUserFullName(String userFullName);
    
    void deleteById(int id);

    List<User> findAll();

    User findOne(int id);

    User findByUserLogin(String login);

    User findByUserMail(String mail);
}
