package xjx.service.imp;

import xjx.dao.UserDao;
import xjx.dao.UserDaoImpl;
import xjx.pojo.User;
import xjx.service.UserService;

import javax.servlet.ServletContext;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username)==null){
            return false;
        }else{
            return true;
        }
    }
}
