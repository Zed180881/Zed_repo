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
    public void save(String fullName, String login, String password,
	    String mail, String phone, String address) {
	if (userRepository.findByFullName(fullName) == null) {
	    User user = new User();
	    if (!fullName.equals(""))
		user.setFullName(fullName);
	    else {
		System.out.println("Invalid user name");
		return;
	    }
	    if (!login.equals(""))
		user.setLogin(login);
	    else {
		System.out.println("Invalid login");
		return;
	    }
	    if (!password.equals(""))
		user.setPassword(password);
	    else {
		System.out.println("Invalid password");
		return;
	    }
	    if (!mail.equals(""))
		user.setMail(mail);
	    else {
		System.out.println("Invalid mail");
		return;
	    }
	    if (!phone.equals(""))
		user.setPhone(phone);
	    else {
		System.out.println("Invalid phone");
		return;
	    }
	    if (!address.equals(""))
		user.setAddress(address);
	    else {
		System.out.println("Invalid address");
		return;
	    }
	    userRepository.save(user);
	}

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
    public void updateUser(String userFullName, String userNewfullName,
	    String login, String password, String mail, String phone,
	    String address) {
	if (userRepository.findByFullName(userFullName) != null) {
	    if (!userNewfullName.equals(""))
		userRepository.findByFullName(userFullName).setFullName(
			userNewfullName);
	    if (!login.equals(""))
		userRepository.findByFullName(userFullName).setLogin(login);
	    if (!password.equals(""))
		userRepository.findByFullName(userFullName).setPassword(
			password);
	    if (!mail.equals(""))
		userRepository.findByFullName(userFullName).setMail(mail);
	    if (!phone.equals(""))
		userRepository.findByFullName(userFullName).setPhone(phone);
	    if (!address.equals(""))
		userRepository.findByFullName(userFullName).setAddress(address);
	}

    }

    @Override
    public List<CommodityOrder> findCommodityOrdersByUser(String userFullName) {
	return userRepository.findByFullName(userFullName).getCommodityOrders();
    }

}
