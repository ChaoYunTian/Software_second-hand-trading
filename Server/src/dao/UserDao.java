package dao;

import model.Goods;
import model.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public int selectByStuidAndPwd(String stuid, String pwd) throws SQLException {
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
        DBUtil.close(rst, pst, connection);
        return result;
    }

    public int insert(User user) throws SQLException{
        Connection connection = DBUtil.getConnection();
        String sql = "insert into user (stuid, nickname, password, address) " +
                "values (?, ?, ?, ?);";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, user.getStuid());
        pst.setString(2, user.getNickname());
        pst.setString(3, user.getPassword());
        pst.setString(4, user.getAddress());

        int result = pst.executeUpdate();
        DBUtil.close(null, pst, connection);
        return result;
    }
}
