package ua.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.User;
import ua.form.filter.UserFilter;

public interface UserService {

    void save(User user);

    User findByUserFullName(String userFullName);

    void deleteByUserFullName(String userFullName);

    void deleteById(int id) throws DataIntegrityViolationException;

    List<User> findAll();

    User findOne(int id);

    User findByUserLogin(String login);

    User findByUserMail(String mail);

    Page<User> findAll(Pageable pageable);

    Page<User> findAll(Pageable pageable, UserFilter filter);
}
