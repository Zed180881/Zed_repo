package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lesson01.User;

public class UserDAO {

    Connection conn;
    PreparedStatement ps;

    public UserDAO() throws SQLException {
	conn = DriverManager.getConnection("jdbc:mysql://localhost/zed1981",
		"root", "pjotr2005");
	Statement statement = conn.createStatement();
	statement.execute("create table if not exists `user` "
		+ "(`id` int auto_increment primary key, "
		+ "`login` varchar(20), " + "`password` varchar(20)"
		+ "`fio` varchar(45)" + "`mail` varchar(45)"
		+ "`phone` varchar(20)" + "`address` varchar(45))");

    }

    public void create(User user) throws SQLException {
	ps = conn.prepareStatement("insert into `user`(`login`, `password`, "
		+ "'fio', 'mail', 'phone', 'address') "
		+ "values(?, ?, ?, ?, ?, ?)");
	ps.setString(1, user.getLogin());
	ps.setString(2, user.getPassword());
	ps.setString(3, user.getFio());
	ps.setString(4, user.getMail());
	ps.setString(5, user.getPhone());
	ps.setString(6, user.getAddress());
	ps.execute();
    }

    public List<User> read() throws SQLException {
	ps = conn.prepareStatement("select * from `user`");
	ResultSet resSet = ps.executeQuery();
	List<User> users = new ArrayList<User>();
	while (resSet.next()) {
	    User user = new User();
	    user.setId(resSet.getInt(1));
	    user.setLogin(resSet.getString(2));
	    user.setPassword(resSet.getString(3));
	    user.setFio(resSet.getString(4));
	    user.setMail(resSet.getString(5));
	    user.setPhone(resSet.getString(6));
	    user.setAddress(resSet.getString(7));
	    users.add(user);
	}
	return users;
    }

    public void delete(User user) throws SQLException {
	ps = conn.prepareStatement("delete from user where `id` = ?");
	ps.setInt(1, user.getId());
	ps.execute();
    }

    public void update(User user) throws SQLException {
	ps = conn.prepareStatement("UPDATE "
		+ "`user` SET `login` = ?, `password` = ?, "
		+ "'fio' = ?, 'mail' = ?, 'phone' = ?, 'address' = ? "
		+ "WHERE `id`=?;");
	ps.setInt(7, user.getId());
	ps.setString(1, user.getLogin());
	ps.setString(2, user.getPassword());
	ps.setString(3, user.getFio());
	ps.setString(4, user.getMail());
	ps.setString(5, user.getPhone());
	ps.setString(6, user.getAddress());
	ps.execute();
    }

}
