package servlet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import dao.ShopcarDao;
import model.Order;
import model.Sheet;
import model.Shopcar;
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
import java.util.ArrayList;


@WebServlet(name = "ShopcarServlet", urlPatterns = "/shopcar")
public class ShopcarServlet extends HttpServlet{
    ShopcarDao shopcarDao=new ShopcarDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));;
        Shopcar result = null;
        try {
            result = shopcarDao.selectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.write(new Gson().toJson(result));
        out.flush();
    }
}
