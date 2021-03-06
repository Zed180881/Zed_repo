package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lesson01.Category;

public class CategoryDAO {

    Connection conn;
    PreparedStatement ps;

    public CategoryDAO() throws SQLException {
	conn = DriverManager.getConnection("jdbc:mysql://localhost/zed1981",
		"root", "pjotr2005");
	Statement statement = conn.createStatement();
	statement.execute("create table if not exists `category` "
		+ "(`id` int auto_increment primary key, "
		+ "`name` varchar(20))");

    }

    public void create(Category category) throws SQLException {
	ps = conn.prepareStatement("insert into `category`(`name`) "
		+ "values(?)");
	ps.setString(1, category.getName());
	ps.execute();
    }

    public List<Category> read() throws SQLException {
	ps = conn.prepareStatement("select * from `category`");
	ResultSet resSet = ps.executeQuery();
	List<Category> categoryList = new ArrayList<>();
	while (resSet.next()) {
	    Category category = new Category();
	    category.setId(resSet.getInt(1));
	    category.setName(resSet.getString(2));
	    categoryList.add(category);
	}
	return categoryList;
    }

    public void delete(Category category) throws SQLException {
	ps = conn.prepareStatement("delete from category where `id` = ?");
	ps.setInt(1, category.getId());
	ps.execute();
    }

    public void update(Category category) throws SQLException {
	ps = conn.prepareStatement("UPDATE `category` SET `name` = ?, "
		+ "WHERE `id`=?;");
	ps.setInt(2, category.getId());
	ps.setString(1, category.getName());
	ps.execute();
    }

}
