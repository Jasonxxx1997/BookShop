package xjx.test;

import org.junit.Test;
import xjx.dao.UserDao;
import xjx.dao.UserDaoImpl;
import xjx.pojo.User;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void queryUserByUsername() {
        UserDao userDao = new UserDaoImpl();
        if (userDao.queryUserByUsername("admin")==null){
            System.out.println("用户不存在");
        }else{
            System.out.println("用户存在");
        }
    }

    @Test
    public void saveUser() {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User(null, "x1x","xxx1997","xjx1997@qq.com");
        if (userDao.saveUser(user)!=1){
            System.out.println("保存失败");
        }else{
            System.out.println("保存成功");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        UserDaoImpl userDao = new UserDaoImpl();
        if (userDao.queryUserByUsernameAndPassword("xjx","xxx1997")==null){
            System.out.println("用户不存在");
        }else{
            System.out.println("用户存在：");
            System.out.println(userDao.queryUserByUsernameAndPassword("xjx","xxx1997"));
        }
    }

}