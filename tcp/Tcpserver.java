package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-04-16
 * Time: 16:22
 */
public class Tcpserver {
    //创建服务器端口号
    private static final int port =9004;

    public static void main(String[] args) throws IOException {

        //1 创建tcp服务器
        ServerSocket server =new ServerSocket(port);
        System.out.println("服务器已经启动");

        //2 等待客户端的连接
        Socket cilent=server.accept();

        //打印客户端的相应信息
        System.out.println(String.format("客户端的IP为：%s,端口号为:%d",
                cilent.getInetAddress().getHostAddress(),cilent.getPort()));

        //3 创建接收与输出流,把资源写在try里会自动进行关闭资源不需要手动关闭
        try(BufferedWriter bufferedWriter=new BufferedWriter
                (new OutputStreamWriter(cilent.getOutputStream()));
            BufferedReader bufferedReader=new BufferedReader
                    (new InputStreamReader(cilent.getInputStream()));
        ){
            while(true){
                //接收信息
                String msg=bufferedReader.readLine();

                if(msg!=null && !msg.equals("")){
                    System.out.println("收到客户端的信息为："+msg);

                    //4 给客户端返回信息
                    String serMsg="我收到了";
                    bufferedWriter.write(serMsg + "\n");//这里一定要加换行符，因为在读的时候是以航为单位的
                    //刷新写缓存
                    bufferedWriter.flush();

                }
            }
        }

    }

}
