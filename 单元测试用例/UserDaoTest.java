package test;

import dao.UserDao;
import model.Goods;
import model.User;
import model.UserAddress;

import org.junit.Test;

import java.sql.SQLException;

public class UserDaoTest {
    UserDao userDao = new UserDao();
    @Test
    public void selectTest() throws Exception{
        try {
            System.out.println(userDao.selectByStuidAndPwd("17020031062", "123456"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertTest() throws Exception{
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
    @Test
    public void insertAdTest() throws Exception{
        UserAddress useraddress = new UserAddress();
        useraddress.setName("马思敏");
        useraddress.setTel("17860711820");
        useraddress.setProvince("云南");
        useraddress.setCity("昆明");
        useraddress.setCounty("石屏");
        useraddress.setAddress("坝心镇");
        try {
            if(userDao.insertAd(useraddress) == 1){
                System.out.println("insert successful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
