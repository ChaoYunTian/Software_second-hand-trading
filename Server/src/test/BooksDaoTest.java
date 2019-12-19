package test;

import java.sql.SQLException;

import org.junit.Test;

import dao.BooksDao;
import model.Books;
import model.Goods;

public class BooksDaoTest {
	BooksDao booksDao=new BooksDao();
	  @Test
	    public void insertTest() throws Exception{
	        Books books = new Books();
	        books.setBookname("123456");
	        books.setAuthor("msm");
	        books.setPublish("中国海洋大学出版社");
	        books.setPrice(25.5f);
	        books.setJiaofu(1);
	        books.setCampus("崂山校区");
	        books.setQuality(10);
	        books.setTel("621663");
	        books.setRemark("this is very nice");
	        try {
	            if(booksDao.insert(books) == 1){
	                System.out.println("insert successful");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	   @Test
	    public void queryBooksList() throws Exception{
	        System.out.println(booksDao.queryBooksList("123456"));
	        System.out.println(booksDao.queryBooksList("12"));
	    }
}
