package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lesson01.CommodityStatus;

public class CommodityStatusDAO {

    Connection conn;
    PreparedStatement ps;

    public CommodityStatusDAO() throws SQLException {
	conn = DriverManager.getConnection("jdbc:mysql://localhost/zed1981",
		"root", "pjotr2005");
	Statement statement = conn.createStatement();
	statement.execute("create table if not exists `commoditystatus` "
		+ "(`id` int auto_increment primary key, "
		+ "`name` varchar(20))");

    }

    public void create(CommodityStatus commodityStatus) throws SQLException {
	ps = conn.prepareStatement("insert into `commoditystatus`(`name`) "
		+ "values(?)");
	ps.setString(1, commodityStatus.getName());
	ps.execute();
    }

    public List<CommodityStatus> read() throws SQLException {
	ps = conn.prepareStatement("select * from `commoditystatus`");
	ResultSet resSet = ps.executeQuery();
	List<CommodityStatus> commodityStatusList = new ArrayList<>();
	while (resSet.next()) {
	    CommodityStatus commodityStatus = new CommodityStatus();
	    commodityStatus.setId(resSet.getInt(1));
	    commodityStatus.setName(resSet.getString(2));
	    commodityStatusList.add(commodityStatus);
	}
	return commodityStatusList;
    }

    public void delete(CommodityStatus commodityStatus) throws SQLException {
	ps = conn
		.prepareStatement("delete from commoditystatus where `id` = ?");
	ps.setInt(1, commodityStatus.getId());
	ps.execute();
    }

    public void update(CommodityStatus commodityStatus) throws SQLException {
	ps = conn.prepareStatement("UPDATE `commoditystatus` SET `name` = ?, "
		+ "WHERE `id`=?;");
	ps.setInt(2, commodityStatus.getId());
	ps.setString(1, commodityStatus.getName());
	ps.execute();
    }

}
