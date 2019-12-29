package vo;

import model.UserAddress;

import dao.UserDao;

public class UserData {
    UserDao dao=new UserDao();

    public int insertAd(UserAddress useraddress) throws Exception {
        return dao.insertAd(useraddress);
     }
}
