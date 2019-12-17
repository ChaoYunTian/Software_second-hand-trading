package test;

import dao.OrderDao;
import dao.OrderDao;
import model.Order;
import model.Order;
import model.Order;
import org.junit.Test;

import javax.management.NotCompliantMBeanException;
import java.sql.SQLException;

public class OrderDaoTest {
    OrderDao orderDao = new OrderDao();
    @Test
    public void selectTest(){
        try {
            System.out.println(orderDao.selectById(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertTest(){
        Order order = new Order();
        order.setUid(3);
        order.setGid(3);
        try {
            if(orderDao.insert(order) == 1){
                System.out.println("insert successful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
