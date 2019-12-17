package dao;

import model.Notice;
import model.Order;
import util.DBUtil;
import  java.sql.Connection;
import  java.sql.PreparedStatement;
import  java.sql.SQLException;
import  java.sql.ResultSet;

public class OrderDao {
    public static Order selectById(int id) throws SQLException{
        Connection connection = DBUtil.getConnection();
        String sql = "select * from `order` where id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rst = pst.executeQuery();
        Order order = null;
        if (rst.next()) {
            order = new Order();
            order.setId(rst.getInt(1));
            order.setUid(rst.getInt(2));
            order.setGid(rst.getInt(3));
        }
        DBUtil.close(rst, pst, connection);
        return order;
    }

    public int insert(Order order)  throws SQLException{
        Connection connection = DBUtil.getConnection();
        String sql = "insert into  `order` (uid,gid)" +
                "values (?,?);";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, order.getUid());
        pst.setInt(2, order.getGid());

        int result = pst.executeUpdate();
        DBUtil.close(null, pst, connection);
        return result;
    }
}
