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
    public void selectTest() throws Exception{
        try {
            System.out.println(goodsDao.selectById(1));
            System.out.println(goodsDao.selectById(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertTest() throws Exception{
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
    public void selectMaxTest() throws Exception{
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
    @Test
    public void queryGoodsList() throws Exception{
        System.out.println(goodsDao.queryGoodsList("丑小鸭"));
        System.out.println(goodsDao.queryGoodsList("123456"));
        System.out.println(goodsDao.queryGoodsList("丑"));
    }
    @Test
    public void showAll() throws Exception{
        try {
        	for (int i = 0; i < goodsDao.showAll().size(); i++) {
                System.out.println(goodsDao.showAll().get(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

