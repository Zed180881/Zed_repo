package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.CommodityOrder;
import ua.entity.User;
import ua.repository.UserRepository;
import ua.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
	if (userRepository.findByFullName(user.getFullName()) == null)
	    userRepository.save(user);
    }

    @Override
    public User findByUserFullName(String userFullName) {
	return userRepository.findByFullName(userFullName);
    }

    @Override
    public void deleteByUserFullName(String userFullName) {
	if (userRepository.findByFullName(userFullName) != null)
	    userRepository.delete(findByUserFullName(userFullName));
    }

    @Override
    public List<User> findAll() {
	return userRepository.findAll();
    }

    @Override
    public void updateUser(String userFullName, User newUser) {
	if (userRepository.findByFullName(userFullName) != null) {
	    if (!newUser.getFullName().equals(""))
		userRepository.findByFullName(userFullName).setFullName(
			newUser.getFullName());
	    if (!newUser.getLogin().equals(""))
		userRepository.findByFullName(userFullName).setLogin(
			newUser.getLogin());
	    if (!newUser.getPassword().equals(""))
		userRepository.findByFullName(userFullName).setPassword(
			newUser.getPassword());
	    if (!newUser.getMail().equals(""))
		userRepository.findByFullName(userFullName).setMail(
			newUser.getMail());
	    if (!newUser.getPhone().equals(""))
		userRepository.findByFullName(userFullName).setPhone(
			newUser.getPhone());
	    if (!newUser.getAddress().equals(""))
		userRepository.findByFullName(userFullName).setAddress(
			newUser.getAddress());
	}

    }

    @Override
    public List<CommodityOrder> findCommodityOrdersByUser(String userFullName) {
	return userRepository.findByFullName(userFullName)
		.getCommodityOrders();
    }

}
