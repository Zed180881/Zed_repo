package lesson02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MySQLTest {

    private static Connection connection;

    @BeforeClass
    public static void create() {
	try {
	    connection = DriverManager.getConnection(
		    "jdbc:mysql://localhost/zed1981", "root", "pjotr2005");
	    Statement statement = connection.createStatement();
	    statement
		    .execute("create table person(id int primary key auto_increment, name varchar(255), age int)");
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @AfterClass
    public static void drop() {
	try {
	    Statement statement = connection.createStatement();
	    statement.execute("drop table person");
	    connection.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Before
    public void add() {
	try {
	    PreparedStatement ps = connection
		    .prepareStatement("insert into person (name, age) values(?, ?)");
	    ps.setString(1, "Ivan");
	    ps.setInt(2, 18);
	    ps.execute();
	    ps.setString(1, "Petro");
	    ps.setInt(2, 25);
	    ps.execute();
	    ps.setString(1, "Mykola");
	    ps.setInt(2, 70);
	    ps.execute();
	    ps.setString(1, "Sergiy");
	    ps.setInt(2, 40);
	    ps.execute();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @After
    public void del() {
	Statement st;
	try {
	    st = connection.createStatement();
	    st.execute("delete from person where id>0");
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void test() {
	Statement st;
	try {
	    st = connection.createStatement();
	    ResultSet rs = st.executeQuery("select * from person");
	    while (rs.next()) {
		int id = rs.getInt(1);
		String name = rs.getString(2);
		int age = rs.getInt(3);
		System.out.println(id + " " + name + " " + age);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

    }

}
