package org.example.servlet;

import org.example.dao.UserDao;
import org.example.exception.AppException;
import org.example.model.User;
import org.example.util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        Map<String, Object> map = new HashMap<>();//返回的数据

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            User o =UserDao.findUser(username,password);
            if(o == null)
                throw new AppException("用户不存在");
//            else if(!password.equals("123"))
//               throw new AppException("账号或密码错误");
            //用户名密码校验成功：
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            map.put("ok", true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("ok", false);
            if(e instanceof AppException){
                map.put("msg", e.getMessage());
            }else{
                map.put("msg", "未知错误，请联系管理员");
            }
        }
        String s = Util.serialize(map);
        resp.getWriter().println(s);
    }

}
