package servlet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import dao.UserDao;
import model.Books;
import model.Sheet;
import model.UserAddress;

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
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
   	 if(action.equals("login")) {
   		 try {
				this.login(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
   	 }
   	 else if(action.equals("insertAd")) {
		 try {
			this.insertAd(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
    }
    private void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String stuid = request.getParameter("stuid");
        String pwd = request.getParameter("pwd");
        Map<String, Object> userData = new HashMap<>();
        int result = 0;
        try {
			result = userDao.selectByStuidAndPwd(stuid, pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        userData.put("result", result);
        PrintWriter out = response.getWriter();
        out.write(new Gson().toJson(userData));
        out.flush();
    }
    private void insertAd(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	 String name = request.getParameter("name");
       	 String tel = request.getParameter("tel");
       	 String province=request.getParameter("province");
        String city = request.getParameter("city");
       	 String county=request.getParameter("county");
       	 String address=request.getParameter("address");
       	 UserAddress useraddress=new UserAddress();
       	useraddress.setName(name);
       	useraddress.setTel(tel);
       	useraddress.setProvince(province);
       	useraddress.setCity(city);
       	useraddress.setCounty(county);
       	useraddress.setAddress(address);
            int result = 0;
            try {
                result = userDao.insertAd(useraddress);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            PrintWriter out = response.getWriter();
            out.write(new Gson().toJson(result));
            out.flush();
    }
}