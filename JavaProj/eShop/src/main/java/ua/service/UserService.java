package ua.service;

import java.util.List;

import ua.entity.CommodityOrder;
import ua.entity.User;

public interface UserService {

    void save(String fullName, String login, String password, String mail,
	    String phone, String address);

    User findByUserFullName(String userFullName);

    void deleteByUserFullName(String userFullName);

    List<User> findAll();

    void updateUser(String userFullName, String userNewfullName, String login, String password, String mail,
	    String phone, String address);

    List<CommodityOrder> findCommodityOrdersByUser(String userFullName);

}
