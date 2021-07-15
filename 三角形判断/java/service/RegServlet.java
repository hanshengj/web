package service;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-06-28
 * Time: 10:09
 */

import type.AngularRelation;
import type.EdgeRelation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-04-03
 * Time: 10:30
 */
public class RegServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        int state = -1;
        String msg = "";
        //从前端获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String idcard = req.getParameter("idcard");
        String password2 = req.getParameter("password2");

        int n1, n2, n3, type;
        n1 = Integer.parseInt(username);
        n2 = Integer.parseInt(password);
        n3 = Integer.parseInt(idcard);
        type = Integer.parseInt(password2);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(type);


        PrintWriter writer = resp.getWriter();
        if (username == null || password == null || idcard == null || password2 == null) {
            //参数不正确
            msg = "参数不存在";

        } else {
            if (type == 1) {
                String ret1 = AngularRelation.Angular(n1, n2, n3);
                state = 200;

                msg = ret1;
            } else {
                String ret2 = EdgeRelation.Edge(n1, n2, n3);
                state = 200;

                msg = ret2;
            }
            //writer.println("{\"state\":" + state +" ,\"msg\":\" " + msg + " \"}");
            // 3.将信息返回给前台
            HashMap<String, Object> result = new HashMap<>();
            result.put("state", state);
            result.put("msg", msg);
            dao.Util.writeMap(resp, result);
        }
    }
}


