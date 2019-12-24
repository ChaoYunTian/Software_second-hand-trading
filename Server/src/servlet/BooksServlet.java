package servlet;

import com.google.gson.Gson;
import dao.BooksDao;
import model.Books;
import model.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet(name = "BooksServlet", urlPatterns = "/books")
public class BooksServlet extends HttpServlet {
    BooksDao booksDao=new BooksDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
    	 if(action.equals("insert")) {
    		 try {
				this.insert(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 }
    	 else if(action.equals("queryBooksList")) {
    		 try {
				this.queryBooksList(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 }
    	 else if(action.equals("showAll")) {
    		 try {
				this.showAll(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 }
    	 else if(action.equals("queryBooksByCampus")) {
    		 try {
				this.queryBooksByCampus(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 }
    }
    private void insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
   	 String bookname = request.getParameter("bookname");
   	 String author = request.getParameter("author");
   	 String publish=request.getParameter("publish");
   	String price=request.getParameter("price");
   	String jiaofu=request.getParameter("jiaofu");
    String campus = request.getParameter("campus");
   	 String quality=request.getParameter("quality");
   	 String tel=request.getParameter("tel");
   	 String remark=request.getParameter("remark");
   	 String bookimg=request.getParameter("bookimg");
   	 Books books=new Books();
   	 books.setBookname(bookname);
   	 books.setAuthor(author);
   	 books.setPublish(publish);
   	 books.setPrice(price);
   	 books.setJiaofu(jiaofu);
   	 books.setCampus(campus);
   	 books.setQuality(quality);
   	 books.setTel(tel);
   	 books.setRemark(remark);
   	 books.setBookimg(bookimg);
        int result = 0;
        try {
            result = booksDao.insert(books);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.write(new Gson().toJson(result));
        out.flush();
   }
    private void queryBooksList(HttpServletRequest request, HttpServletResponse response) throws Exception {
   	 String bookname = request.getParameter("bookname");
        Books result = null;
        result = booksDao.queryBooksList(bookname);
        PrintWriter out = response.getWriter();
        out.write(new Gson().toJson(result));
        out.flush();
   }
    private void showAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Books> result = null;
        try {
            result = booksDao.showAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.write(new Gson().toJson(result));
        out.flush();
   }
    private void queryBooksByCampus(HttpServletRequest request, HttpServletResponse response) throws Exception {
      	 String campus = request.getParameter("campus");
           Books result = null;
           result = booksDao.queryBooksList(campus);
           PrintWriter out = response.getWriter();
           out.write(new Gson().toJson(result));
           out.flush();
      }
    
}
