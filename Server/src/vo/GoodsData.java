package vo;

import java.util.ArrayList;

import dao.GoodsDao;
import model.Goods;

public class GoodsData {
    GoodsDao dao=new GoodsDao();
    ArrayList<Goods> list=new ArrayList<Goods>();
    public Goods selectById(int id) throws Exception {
        return dao.selectById(id);
    }

    public int insert(Goods goods) throws Exception {
       return dao.insert(goods);
    }
    public int seletMaxId() throws Exception {
        return dao.seletMaxId();
    }
    public Goods queryGoodsList(String name) throws Exception {
        return dao.queryGoodsList(name);
    }
    public ArrayList<Goods> showAll() throws Exception {
    	return dao.showAll();
    }
}
