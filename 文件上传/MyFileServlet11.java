import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-04-06
 * Time: 16:11
 */
@MultipartConfig
public class MyFileServlet11 extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //设置编码
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        //得到上传的文件对象
        Part part=request.getPart("myfile");

        //得到唯一的标识
        UUID uuid=UUID.randomUUID();
        //将文件写入磁盘
        //part.getSubmittedFileName()得到文件的扩展名
        part.write("D:\\"+uuid +part.getSubmittedFileName());

        //给客户端提示，文件上传成功
        PrintWriter printWriter=response.getWriter();
        printWriter.println("文件上传穿成功");

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        this.doPost(request,response);
    }
}
