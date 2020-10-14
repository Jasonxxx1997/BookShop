package xjx.web;

import xjx.pojo.User;
import xjx.service.UserService;
import xjx.service.imp.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 一个模块只使用一个Servlet程序，将login和rejist整合到一块
 * 使用html中的hidden标签来对请求做出响应的反应
 *<input type="hidden" name="action" value="login"/>
 */
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    /***
     *  处理登录的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User loginUser  = userService.login(new User(null,username,password,null));
        if (loginUser==null){
            //把错误信息和回显的表单信息保存到request域中
            req.setAttribute("msg","用户名或密码错误！");
            req.setAttribute("username",username);
            System.out.println("登录失败");
            //跳回主页
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            System.out.println("登录成功");
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }
    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2.检查验证码是否正确====还没部署服务器，现在只要验证码为abcde即可
        if ("abcde".equalsIgnoreCase(code)){
            //3.检查用户名是否正确
            if (userService.existsUsername(username)){
                //把回显信息保存到request域中
                req.setAttribute("msg","用户名已存在");
                req.setAttribute("username",username);
                req.setAttribute("email",email);

                System.out.println("用户名已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else{
                userService.registUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);

            }

        }else{
            //把回显信息保存到request域中
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);

            //若不对就跳回注册界面
            System.out.println("验证码错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
       // System.out.println(action);
        if ("login".equals(action)){
            System.out.println("处理登录的需求");
            login(req,resp);

        }else if ("regist".equals(action)){
            System.out.println("处理注册的需求");
            regist(req,resp);
        }
    }
}
