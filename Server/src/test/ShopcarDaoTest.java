package test;

import dao.ShopcarDao;
import model.Notice;
import model.Shopcar;
import org.junit.Test;

import java.sql.SQLException;

public class ShopcarDaoTest {
    ShopcarDao shopcarDao = new ShopcarDao();
    @Test
    public void selectTest() throws Exception{
        try {
            System.out.println(shopcarDao.selectById(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertTest() throws Exception{
        Shopcar shopcar = new Shopcar();
        shopcar.setUid(66);
        shopcar.setGid(88);

        try {
            if(shopcarDao.insert(shopcar) == 1){
                System.out.println("insert successful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
