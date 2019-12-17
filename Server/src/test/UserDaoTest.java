package test;

import dao.UserDao;
import model.Goods;
import model.User;
import org.junit.Test;

import java.sql.SQLException;

public class UserDaoTest {
    UserDao userDao = new UserDao();
    @Test
    public void selectTest(){
        try {
            System.out.println(userDao.selectByStuidAndPwd("17020031062", "123456"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertTest(){
        User user = new User();
        user.setStuid("17020031070");
        user.setNickname("wangguangshan");
        user.setPassword("888888");
        user.setAddress("hahaha");

        try {
            if(userDao.insert(user) == 1){
                System.out.println("insert successful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
