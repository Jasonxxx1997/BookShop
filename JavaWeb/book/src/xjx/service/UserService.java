package xjx.service;

import xjx.pojo.User;

public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录用户
     * @return
     */
    public User login(User user);

    /**
     * 检查用户名是否存在
     * @param username
     * @return
     */
    public boolean existsUsername(String username);
}
