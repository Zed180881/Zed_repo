package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lesson01.OrderStatus;

public class OrderStatusDAO {

    Connection conn;
    PreparedStatement ps;

    public OrderStatusDAO() throws SQLException {
	conn = DriverManager.getConnection("jdbc:mysql://localhost/zed1981",
		"root", "pjotr2005");
	Statement statement = conn.createStatement();
	statement.execute("create table if not exists `orderstatus` "
		+ "(`id` int auto_increment primary key, "
		+ "`name` varchar(20))");

    }

    public void create(OrderStatus orderStatus) throws SQLException {
	ps = conn.prepareStatement("insert into `orderstatus`(`name`) "
		+ "values(?)");
	ps.setString(1, orderStatus.getName());
	ps.execute();
    }

    public List<OrderStatus> read() throws SQLException {
	ps = conn.prepareStatement("select * from `orderstatus`");
	ResultSet resSet = ps.executeQuery();
	List<OrderStatus> orderStatusList = new ArrayList<>();
	while (resSet.next()) {
	    OrderStatus orderStatus = new OrderStatus();
	    orderStatus.setId(resSet.getInt(1));
	    orderStatus.setName(resSet.getString(2));
	    orderStatusList.add(orderStatus);
	}
	return orderStatusList;
    }

    public void delete(OrderStatus orderStatus) throws SQLException {
	ps = conn.prepareStatement("delete from orderstatus where `id` = ?");
	ps.setInt(1, orderStatus.getId());
	ps.execute();
    }

    public void update(OrderStatus orderStatus) throws SQLException {
	ps = conn.prepareStatement("UPDATE `orderstatus` SET `name` = ?, "
		+ "WHERE `id`=?;");
	ps.setInt(2, orderStatus.getId());
	ps.setString(1, orderStatus.getName());
	ps.execute();
    }

}
