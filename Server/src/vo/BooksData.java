package vo;

import java.util.ArrayList;

import dao.BooksDao;
import model.Books;
import model.Goods;

public class BooksData {
	BooksDao dao=new BooksDao();
	 public int insert(Books books) throws Exception {
	       return dao.insert(books);
	    }
	 public Books queryGoodsList(String bookname) throws Exception {
	        return dao.queryBooksList(bookname);
	    }
	 public ArrayList<Books> showAll() throws Exception {
	    	return dao.showAll();
	    }
	 public Books queryBooksByCampus(String campus) throws Exception {
	        return dao.queryBooksByCampus(campus);
	    }
}
