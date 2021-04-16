package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:模拟实现http服务器
 * User: hp
 * Date: 2021-04-16
 * Time: 17:11
 */
public class CustomHTTP {
    //定义服务器的端口号
    private static final int port =9005;
    public static void main(String[] args) throws IOException {
        //1 创建服务器
        ServerSocket server =new ServerSocket(port);

        //2 等待客户端的连接
        Socket cilent1=server.accept();
        //3 创建读写缓存区
        try(BufferedWriter writer=new BufferedWriter(
                new OutputStreamWriter(cilent1.getOutputStream()));
            BufferedReader reader=new BufferedReader(
                    new InputStreamReader(cilent1.getInputStream()));
        ){

            //得到客户端的请求信息
            String firstLine=reader.readLine();
            if(firstLine!=null && !firstLine.equals("")){

                //按空格对首行进行拆分
                String[] ret=firstLine.split(" ");
                String method=ret[0];//方法类型
                String url=ret[1];//url
                String version=ret[2];//版本号
                //给服务器输出客户的请求信息
                System.out.println(String.format("方法类型：%s,URL：%s,版本号：%s",method,url,version));


                //业务逻辑
                String content="<h1>未知</h1>";
                if(url.contains("404")){
                    content="<h1>未找到页面信息</h1>";
                }else if(url.contains("200")){
                    content="<h1>欢迎来到新世界</h1>";
                }
                //给浏览器反馈信息,严格按照response格式输出
                //先写入首行信息
                writer.write(version +"200" +"ok"+"\n");
                //输入头部
                writer.write("Content-Type: text/html;charset=utf-8\n");
                writer.write("Content-Length: " + content.getBytes().length + "\n");
                //空行，表示头部结束
                writer.write("\n");
                //写入body
                writer.write(content);
                //刷新huancun
                writer.flush();

            }
        }


    }
}
