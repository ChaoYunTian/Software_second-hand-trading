package test;

import dao.NoticeDao;
import model.Goods;
import model.Notice;
import org.junit.Test;

import javax.management.NotCompliantMBeanException;
import java.sql.SQLException;

public class NoticeDaoTest {
    NoticeDao noticeDao = new NoticeDao();
    @Test
    public void selectTest(){
        try {
            System.out.println(noticeDao.selectById(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertTest(){
        Notice notice = new Notice();
        notice.setUid(12);
        notice.setGid(22);
        notice.setTime("12");

        try {
            if(noticeDao.insert(notice) == 1){
                System.out.println("insert successful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
