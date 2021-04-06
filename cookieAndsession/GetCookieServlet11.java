import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-04-06
 * Time: 17:01
 */
public class GetCookieServlet11 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1.设置两个基础的属性
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        Cookie[] cookies=request.getCookies();

        PrintWriter printWriter=response.getWriter();
        for (Cookie ck:cookies
             ) {
            printWriter.println(String.format("name=%s->values=%s",ck.getName(),ck.getValue()));
            printWriter.println();

        }
    }
}
