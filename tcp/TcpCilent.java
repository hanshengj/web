package tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-04-16
 * Time: 16:47
 */
public class TcpCilent {
    //定义服务器端口与IP
    //private static final int port=9004;
    private static final int port=9005;
    private static final String IP="127.0.0.1";
    public static void main(String[] args) throws IOException {
        //1,创建客户端，并连接服务器
        Socket cilent=new Socket(IP,port);


        //创建读写缓存去
        try(BufferedReader bufferedReader=new BufferedReader(
                new InputStreamReader(cilent.getInputStream()));
            BufferedWriter bufferedWriter=new BufferedWriter(
                    new OutputStreamWriter(cilent.getOutputStream()));
            Scanner msg=new Scanner(System.in);
        ){

            while (true){
                //提示客户输入请求
                System.out.println("->");
                String cilMsg=msg.nextLine();
                //发送请求给服务器并刷新缓存区
                bufferedWriter.write(cilMsg +"\n");//这里一定要加换行符，因为在读的时候是以航为单位的
                bufferedWriter.flush();

                //接收服务器的反馈
                String serMsg=bufferedReader.readLine();
                System.out.println("服务器反馈："+serMsg);

            }
        }

    }
}
