package udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-04-13
 * Time: 17:52
 */
public class UdpClient {
    //服务器的ip
    private static final String ip="127.0.0.1";
    //服务器的端口号
    private static final int port=9999;
    //数据包的大小
    private static final int bleng=1024;

    public static void main(String[] args) throws IOException {
        //1、创建客户户端
        DatagramSocket datapramSocket=new DatagramSocket();

        //让用户输入发送信息
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.print("请输入您的请求：");
            String msg=sc.nextLine();
            //2、构建请求数据包
            DatagramPacket requestPacket=new DatagramPacket(
                    msg.getBytes(),
                    msg.getBytes().length,
                    //服务器的IP
                    InetAddress.getByName(ip),
                    //服务器的端口号
                    port
            );

            //3、向服务器发送请求
            datapramSocket.send(requestPacket);

            //接收服务器的反馈信息
            //接收信息需要先构建接收数据的数据包,指定数据包的大小
            DatagramPacket serverPacket=new DatagramPacket(new byte[bleng],bleng);
            datapramSocket.receive(serverPacket);
            //打印服务器的反馈信息
            System.out.println("收到服务器的信息为：" + new String(serverPacket.getData()));
        }
    }
}
