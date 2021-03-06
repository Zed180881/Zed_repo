package ua.service;

import java.util.List;

import ua.entity.CommodityOrder;
import ua.entity.User;

public interface UserService {

    void save(User user);

    User findByUserFullName(String userFullName);

    void deleteByUserFullName(String userFullName);

    List<User> findAll();

    void updateUser(String userFullName, User newUser);

    List<CommodityOrder> findCommodityOrdersByUser(String userFullName);

}
