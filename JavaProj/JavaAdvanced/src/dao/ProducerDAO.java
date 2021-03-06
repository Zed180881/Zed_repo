package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lesson01.Producer;

public class ProducerDAO {

    Connection conn;
    PreparedStatement ps;

    public ProducerDAO() throws SQLException {
	conn = DriverManager.getConnection("jdbc:mysql://localhost/zed1981",
		"root", "pjotr2005");
	Statement statement = conn.createStatement();
	statement.execute("create table if not exists `producer` "
		+ "(`id` int auto_increment primary key, "
		+ "`name` varchar(20))");

    }

    public void create(Producer producer) throws SQLException {
	ps = conn.prepareStatement("insert into `producer`(`name`) "
		+ "values(?)");
	ps.setString(1, producer.getName());
	ps.execute();
    }

    public List<Producer> read() throws SQLException {
	ps = conn.prepareStatement("select * from `producer`");
	ResultSet resSet = ps.executeQuery();
	List<Producer> producers = new ArrayList<>();
	while (resSet.next()) {
	    Producer producer = new Producer();
	    producer.setId(resSet.getInt(1));
	    producer.setName(resSet.getString(2));
	    producers.add(producer);
	}
	return producers;
    }

    public void delete(Producer producer) throws SQLException {
	ps = conn.prepareStatement("delete from producer where `id` = ?");
	ps.setInt(1, producer.getId());
	ps.execute();
    }

    public void update(Producer producer) throws SQLException {
	ps = conn.prepareStatement("UPDATE `producer` SET `name` = ?, "
		+ "WHERE `id`=?;");
	ps.setInt(2, producer.getId());
	ps.setString(1, producer.getName());
	ps.execute();
    }

}
