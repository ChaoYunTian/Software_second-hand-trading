package dao;

import model.Notice;
import model.Order;
import util.DBUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NoticeDao {
    public Notice selectById(int id) throws SQLException{
        Connection connection = DBUtil.getConnection();
        String sql = "select * from notice where id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rst = pst.executeQuery();
        Notice notice = null;
        if (rst.next()) {
            notice = new Notice();
            notice.setId(rst.getInt(1));
            notice.setUid(rst.getInt(2));
            notice.setGid(rst.getInt(3));
            notice.setTime(rst.getString(4));
        }
        DBUtil.close(rst, pst, connection);
        return notice;
    }

    public int insert(Notice notice)  throws SQLException{
        Connection connection = DBUtil.getConnection();
        String sql = "insert into  notice (uid,gid,time)" +
                "values (?,?,?);";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, notice.getUid());
        pst.setInt(2, notice.getGid());
        pst.setString(3, notice.getTime());
        int result = pst.executeUpdate();
        DBUtil.close(null, pst, connection);
        return result;
    }
}
