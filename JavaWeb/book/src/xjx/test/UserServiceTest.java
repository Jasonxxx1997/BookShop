package xjx.test;

import org.junit.Test;
import xjx.pojo.User;
import xjx.service.imp.UserServiceImpl;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserServiceImpl userService = new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null,"wyuddfan","124545","15152@com"));
        userService.registUser(new User(null,"zhangsfsfhan","12dsd4545","1ddddds52@com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"xjx","xxx1997",null)));
    }

    @Test
    public void existsUsername() {
        System.out.println(userService.existsUsername("x1x"));
    }
}