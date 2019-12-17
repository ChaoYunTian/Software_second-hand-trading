package test;

import dao.GoodsDao;
import dao.NoticeDao;
import model.Goods;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import javax.management.NotCompliantMBeanException;

public class GoodsDaoTest {
    GoodsDao goodsDao = new GoodsDao();
    @Test
    public void selectTest(){
        try {
            System.out.println(goodsDao.selectById(1));
            System.out.println(goodsDao.selectById(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertTest(){
        Goods goods = new Goods();
        goods.setName("123456");
        goods.setCampus("崂山校区");
        goods.setQuality(10);
        goods.setPrice(25.5f);
        goods.setTel("621663");
        goods.setRemark("this is very nice");
        try {
            if(goodsDao.insert(goods) == 1){
                System.out.println("insert successful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectMaxTest(){
        try {
            System.out.println(goodsDao.seletMaxId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void  timeTest(){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

}

