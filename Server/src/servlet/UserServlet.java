package servlet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import dao.UserDao;
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
        String stuid = request.getParameter("stuid");
        String pwd = request.getParameter("pwd");
        Map<String, Object> userData = new HashMap<>();
        int result = 0;
        try {
            result = userDao.selectByStuidAndPwd(stuid, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        userData.put("result", result);
        PrintWriter out = response.getWriter();
        out.write(new Gson().toJson(userData));
        out.flush();
    }
}