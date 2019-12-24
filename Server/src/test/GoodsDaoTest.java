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
    public void deleteTest() throws Exception{
        try {
            System.out.println(goodsDao.deleteById(13));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertTest() throws Exception{
        Goods goods = new Goods();
        goods.setName("行李箱");
        goods.setCampus("崂山校区");
        goods.setQuality("8成新");
        goods.setPrice("58");
        goods.setTel("17860711820");
        goods.setRemark("低价急售");
        goods.setThingimg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577091497976&di=01b5705117a077ebb56b05bd59acf74a&imgtype=0&src=http%3A%2F%2Fimg000.hc360.cn%2Fm7%2FM0A%2F83%2FA7%2FwKhQpFcYSbmELBxKAAAAAKaq4yQ095.jpg");
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

