package servlet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import dao.GoodsDao;
import model.Goods;
import model.Sheet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vo.IndexData;
import vo.Sheetitem;

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
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "GoodsServlet", urlPatterns = "/goods")
public class GoodsServlet extends HttpServlet {
    GoodsDao goodsDao=new GoodsDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
    	 if(action.equals("selectById")){ 
             try {
				this.selectById(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
    	 else if(action.equals("insert")) {
    		 try {
				this.insert(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 }
    	 else if(action.equals("selectMaxId")) {
    		 try {
				this.selectMaxId(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 }
    	 else if(action.equals("queryGoodsList")) {
    		 try {
				this.queryGoodsList(request, response);
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
    }
    private void selectById(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	 int id = Integer.parseInt(request.getParameter("id"));
         Goods result = null;
         try {
             result = goodsDao.selectById(id);
         } catch (SQLException e) {
             e.printStackTrace();
         }
         PrintWriter out = response.getWriter();
         out.write(new Gson().toJson(result));
         out.flush();
    }
    private void insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
   	 String name = request.getParameter("name");
   	 String campus=request.getParameter("campus");
   	 int quality=Integer.parseInt(request.getParameter("quality"));
   	 int price=Integer.parseInt(request.getParameter("price"));
   	 String tel=request.getParameter("tel");
   	 String remark=request.getParameter("remark");
   	 Goods goods=new Goods();
   	 goods.setName(name);
   	 goods.setCampus(campus);
   	 goods.setQuality(quality);
   	 goods.setPrice(price);
   	 goods.setTel(tel);
   	 goods.setRemark(remark);
        int result = 0;
        try {
            result = goodsDao.insert(goods);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.write(new Gson().toJson(result));
        out.flush();
   }
    private void selectMaxId(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	int result = 0;
        try {
            result = goodsDao.seletMaxId();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.write(new Gson().toJson(result));
        out.flush();
    }
    private void queryGoodsList(HttpServletRequest request, HttpServletResponse response) throws Exception {
   	 String name = request.getParameter("name");
        Goods result = null;
        result = goodsDao.queryGoodsList(name);
        PrintWriter out = response.getWriter();
        out.write(new Gson().toJson(result));
        out.flush();
   }
    private void showAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Goods> result = null;
        try {
            result = goodsDao.showAll();
            HttpSession session = request.getSession();
            session.setAttribute("result", result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.write(new Gson().toJson(result));
        out.flush();
   }
    
}
