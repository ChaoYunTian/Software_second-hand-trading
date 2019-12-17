package dao;

import model.Goods;
import model.Order;
import util.DBUtil;
import  java.sql.Connection;
import  java.sql.PreparedStatement;
import  java.sql.SQLException;
import  java.sql.ResultSet;

public class GoodsDao {
    public Goods selectById(int id) throws SQLException{
        Connection connection = DBUtil.getConnection();
        String sql = "select * from goods where id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rst = pst.executeQuery();
        Goods goods = null;
        if (rst.next()) {
            goods = new Goods();
            goods.setId(rst.getInt(1));
            goods.setName(rst.getString(2));
            goods.setCampus(rst.getString(3));
            goods.setQuality(rst.getInt(4));
            goods.setPrice(rst.getFloat(5));
            goods.setTel(rst.getString(6));
            goods.setRemark(rst.getString(7));
        }
        DBUtil.close(rst, pst, connection);
        return goods;
    }

    public int insert(Goods goods) throws SQLException{
        Connection connection = DBUtil.getConnection();
        String sql = "insert into goods (name, campus, quality, price, tel, remark) " +
                     "values (?, ?, ?, ?, ?, ?);";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, goods.getName());
        pst.setString(2, goods.getCampus());
        pst.setInt(3, goods.getQuality());
        pst.setFloat(4, goods.getPrice());
        pst.setString(5, goods.getTel());
        pst.setString(6, goods.getRemark());

        int result = pst.executeUpdate();
        DBUtil.close(null, pst, connection);
        return result;
    }

    public int seletMaxId() throws SQLException{
        Connection connection = DBUtil.getConnection();
        String sql = "select max(id) from goods";
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rst = pst.executeQuery();
        int result = 0;
        if (rst.next())
            result = rst.getInt(1);
        DBUtil.close(rst, pst, connection);
        return result;
    }
}
