package test;

import org.junit.Test;
import util.DBUtil;

import java.sql.Connection;

public class JDBCTest {
    @Test
    public void connectionTest(){
        Connection connection = DBUtil.getConnection();
        System.out.println(connection);
        DBUtil.close(null, null, connection);
    }

}
