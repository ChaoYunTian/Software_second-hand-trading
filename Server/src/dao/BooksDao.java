package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Books;
import util.DBUtil;

public class BooksDao {
	   public int insert(Books books) throws Exception{
	        Connection connection = DBUtil.getConnection();
	        String sql = "insert into books (bookname, author, publish, price, jiaofu, campus, quality, tel, remark) " +
	                     "values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
	        PreparedStatement pst = connection.prepareStatement(sql);
	        pst.setString(1, books.getBookname());
	        pst.setString(2, books.getAuthor());
	        pst.setString(3, books.getPublish());
	        pst.setFloat(4, books.getPrice());
	        pst.setInt(5, books.getJiaofu());
	        pst.setString(6, books.getCampus());
	        pst.setInt(7, books.getQuality());
	        pst.setString(8, books.getTel());
	        pst.setString(9, books.getRemark());

	        int result = pst.executeUpdate();
	        
	        return result;
	    }
	   public Books queryBooksList(String bookname) {
	    	Books books = null;
	    	try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = null;

	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/server" +
	                "?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC","root","root");

	            StringBuilder sql = new StringBuilder(" SELECT * FROM books where 1=1 ");
	            List<String> paramList = new ArrayList<String>();
	            if(bookname != null && !"".equals(bookname.trim())) {
	                sql.append(" and bookname like '%' ? '%' ");
	                paramList.add(bookname);
	            }
	            PreparedStatement ptmt = conn.prepareStatement(sql.toString());
	            for (int i=0;i<paramList.size();i++) {
	                ptmt.setString(i+1,paramList.get(i));
	            }

	            
	            ResultSet rst = ptmt.executeQuery();
	            if (rst.next()) {
	                
	            	books = new Books();
	                books.setBookname(rst.getString(1));
	                books.setAuthor(rst.getString(2));
	                books.setPublish(rst.getString(3));
	                books.setPrice(rst.getFloat(4));
	                books.setJiaofu(rst.getInt(5));
	                books.setCampus(rst.getString(6));
	                books.setQuality(rst.getInt(7));
	                books.setTel(rst.getString(8));
	                books.setRemark(rst.getString(9));
	            }
	           
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return books;
	    }
}
