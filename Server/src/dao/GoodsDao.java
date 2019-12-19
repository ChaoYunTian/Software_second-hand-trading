package dao;

import model.Goods;
import util.DBUtil;
import  java.sql.Connection;
import java.sql.DriverManager;
import  java.sql.PreparedStatement;
import  java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDao {
    public Goods selectById(int id) throws Exception{
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
        
        return goods;
    }

    public int insert(Goods goods) throws Exception{
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
        
        return result;
    }

    public int seletMaxId() throws Exception{
        Connection connection = DBUtil.getConnection();
        String sql = "select max(id) from goods";
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rst = pst.executeQuery();
        int result = 0;
        if (rst.next())
            result = rst.getInt(1);
       
        return result;
    }
    public Goods queryGoodsList(String name) {
    	Goods goods = null;
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null;

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/server" +
                "?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC","root","root");

            StringBuilder sql = new StringBuilder(" SELECT * FROM Goods where 1=1 ");
            List<String> paramList = new ArrayList<String>();
            if(name != null && !"".equals(name.trim())) {
                sql.append(" and name like '%' ? '%' ");
                paramList.add(name);
            }
            PreparedStatement ptmt = conn.prepareStatement(sql.toString());
            for (int i=0;i<paramList.size();i++) {
                ptmt.setString(i+1,paramList.get(i));
            }

            
            ResultSet rst = ptmt.executeQuery();
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
           
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return goods;
    }
    public ArrayList<Goods> showAll() throws Exception{
        Connection connection = DBUtil.getConnection();
        String sql = "select * from goods ";
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rst = pst.executeQuery();
        ArrayList<Goods> list=new ArrayList<Goods>();
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
            list.add(goods);
        }
        
        return list;
    }
}
