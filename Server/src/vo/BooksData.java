package vo;

import dao.BooksDao;
import model.Books;

public class BooksData {
	BooksDao dao=new BooksDao();
	 public int insert(Books books) throws Exception {
	       return dao.insert(books);
	    }
	 public Books queryGoodsList(String bookname) throws Exception {
	        return dao.queryBooksList(bookname);
	    }
}
