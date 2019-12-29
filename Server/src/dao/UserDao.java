package dao;

import model.User;
import model.UserAddress;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    public int selectByStuidAndPwd(String stuid, String pwd) throws Exception {
        //获取数据库连接
        Connection connection = DBUtil.getConnection();
        String sql = "select id from user where stuid = ? and password = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, stuid);
        pst.setString(2, pwd);
        ResultSet rst = pst.executeQuery();
        int result = 0;
        if (rst.next())
            result = rst.getInt(1);
        return result;
    }

    public int insert(User user) throws Exception{
        Connection connection = DBUtil.getConnection();
        String sql = "insert into user (stuid, nickname, password, address) " +
                "values (?, ?, ?, ?);";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, user.getStuid());
        pst.setString(2, user.getNickname());
        pst.setString(3, user.getPassword());
        pst.setString(4, user.getAddress());

        int result = pst.executeUpdate();
        return result;
    }
    public int insertAd(UserAddress useraddress) throws Exception {
    	  Connection connection = DBUtil.getConnection();
          String sql = "insert into useraddress (name, tel, province, city, county, address) " +
                  "values (?, ?, ?, ? ,? ,?);";
          PreparedStatement pst = connection.prepareStatement(sql);
          pst.setString(1, useraddress.getName());
          pst.setString(2, useraddress.getTel());
          pst.setString(3, useraddress.getProvince());
          pst.setString(4, useraddress.getCity());
          pst.setString(5, useraddress.getCounty());
          pst.setString(6, useraddress.getAddress());

          int result = pst.executeUpdate();
          return result;
    }
}
