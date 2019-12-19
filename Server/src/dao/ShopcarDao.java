package dao;

import model.Notice;
import model.Shopcar;
import util.DBUtil;
import  java.sql.Connection;
import  java.sql.PreparedStatement;
import  java.sql.SQLException;
import  java.sql.ResultSet;

public class ShopcarDao {
    public Shopcar selectById(int id) throws Exception {
        //获取数据库连接
        Connection connection = DBUtil.getConnection();
        String sql = "select * from shopcar where id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rst = pst.executeQuery();
        Shopcar shopcar = null;
        if (rst.next()) {
            shopcar = new Shopcar();
            shopcar.setId(rst.getInt(1));
            shopcar.setUid(rst.getInt(2));
            shopcar.setGid(rst.getInt(3));
        }
        DBUtil.close(rst, pst, connection);
        return shopcar;
    }

    public int insert(Shopcar shopcar)  throws Exception{
        Connection connection = DBUtil.getConnection();
        String sql = "insert into  shopcar (uid,gid)" +
                "values (?,?);";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, shopcar.getUid());
        pst.setInt(2, shopcar.getGid());
        int result = pst.executeUpdate();
        DBUtil.close(null, pst, connection);
        return result;
    }
}
