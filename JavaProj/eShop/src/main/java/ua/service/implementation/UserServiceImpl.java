package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.User;
import ua.repository.UserRepository;
import ua.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private User user;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
	userRepository.save(user);

    }

    @Override
    public User findByUserFullName(String userFullName) {
	return userRepository.findByFullName(userFullName);
    }

    @Override
    public void deleteByUserFullName(String userFullName) {
	if ((user = userRepository.findByFullName(userFullName)) != null)
	    userRepository.delete(user);
    }

    @Override
    public List<User> findAll() {
	return userRepository.findAll();
    }

    @Override
    public User findOne(int id) {
	return userRepository.findOne(id);
    }

    @Override
    public void deleteById(int id) {
	userRepository.delete(id);
    }

    @Override
    public User findByUserLogin(String login) {
	return userRepository.findByLogin(login);
    }

    @Override
    public User findByUserMail(String mail) {
	return userRepository.findByMail(mail);
    }
}
