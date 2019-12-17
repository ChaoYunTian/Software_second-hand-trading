package servlet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import com.sun.deploy.net.HttpRequest;
import dao.GoodsDao;
import dao.NoticeDao;
import model.Goods;
import model.Notice;
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
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



@WebServlet(name = "NoticeServlet", urlPatterns = "/notice")
public class NoticeServlet extends HttpServlet {
    NoticeDao noticeDao = new NoticeDao();
    GoodsDao goodsDao = new GoodsDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        int uid = Integer.parseInt(request.getParameter("uid"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        int quality = Integer.parseInt(request.getParameter("quality"));
        String campus = request.getParameter("campus");
        String tel = request.getParameter("tel");
        String remark = request.getParameter("remark");

        Goods goods = new Goods();
        goods.setName(name);
        goods.setQuality(quality);
        goods.setPrice(price);
        goods.setCampus(campus);
        goods.setTel(tel);
        goods.setRemark(remark);
        int result = 0;
        try {
            result = goodsDao.insert(goods);
            Notice notice = new Notice();
            notice.setUid(uid);
            notice.setGid(goodsDao.seletMaxId());
            notice.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            result = noticeDao.insert(notice);
        } catch (SQLException e) {
            e.printStackTrace();
            //todo 异常处理
        }
        Map<String, Object> resultMap = new HashMap<>();
        if(result == 1)
            resultMap.put("msg", "success");
        else
            resultMap.put("msg", "failed");
        PrintWriter out = response.getWriter();
        out.write(new Gson().toJson(resultMap));
        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getParameter("method");
        if("add".equals(method)) {
            add(request, response);
        }

    }
}