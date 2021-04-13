package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-04-13
 * Time: 17:15
 */
public class UdpServer {
    //创建服务器端口号
    private static final int port=9999;
    //接受数据的容器大小
    private static final int bleng=1024;
    public static void main(String []args) throws IOException {

        //1、创建一个udp服务器,需要加上端口号
        DatagramSocket datagramSocket=new DatagramSocket(port);

        //循环读入服务气的请求，服务器要一直工作
        while(true){
            //创建指定大小的数据包接收客户端请求，udp是通过数据包进行传输的，
            // 所以不管接收还是发送，都先需要构建一个数据包，底层是一个字节数组，要指定大小
            DatagramPacket clientPacket=new  DatagramPacket(new byte[bleng],bleng);

            //2、等待客户端的请求,将接收容器作为参数
            datagramSocket.receive(clientPacket);
            //执行了杀那个面的语句表示已经有客户端连接了

            //拿到客户端的请求信息
            String msg=new String (clientPacket.getData());
            System.out.println("接受到了客户端的信息:" + msg);

            //给客户顿反馈信息
            //String serMsg="已经收到信息了";
            String serMsg = msg.replace("吗？", ".").
                    replace("你", "我");
            //构建发给客户端的数据包，需要四个参数
            DatagramPacket sendMsg=new DatagramPacket(
                    //字节数组
                    serMsg.getBytes(),
                    //数组的大小注意，数据包传的是字节数组的大小而不是字符串的大小
                    serMsg.getBytes().length,
                   //客户端的IP地址
                    clientPacket.getAddress(),
                    //客户端的端口号
                    clientPacket.getPort()
            );
            //给客户端发送数据包
            datagramSocket.send(sendMsg);


        }
    }
}
