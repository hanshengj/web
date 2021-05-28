package servlet.user;
import xpu.dao.UserinfoDAO;
import xpu.vo.UserinfoVO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyUserServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //返回上页
        String goBack="<br><a href='javascript:window.history.go(-1);'>返回上页</a>";

        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();

        String name=request.getParameter("modify");
        if(name!=null) //单击了‘修改用户’
        {
            String username=request.getParameter("modfyName");
            String password=request.getParameter("password");
            UserinfoVO user=new UserinfoVO();
            user.setUsername(username);
            user.setPassword(password);
            UserinfoDAO userDAO= null;
            try {
                userDAO = new UserinfoDAO();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                userDAO.update(user);
            } catch (SQLException e) {
                e.printStackTrace();
                out.print("修改失败："+e.getLocalizedMessage());
                out.print(goBack);
                return;
            }
        }
        out.print("修改成功！");
        out.print(goBack);
        out.close();
    }
}