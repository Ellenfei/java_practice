package IOpractice;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Ellen on 2017/6/16.
 * 需求：定义一个应用程序，用于接收UDP协议传输的数据并处理
 * 步骤：
 * 1.定义udpsocket服务，通常会监听一个端口，给接收网络应用程序定义一个数字标识
 * 2.定义一个数据包，存储接收到的字节数据
 * 2.通过socket服务中的receive方法将收到的数据存入已定义好的数据包中
 * 4.通过数据包对象的特有功能，将这些不同的数据取出，打印在控制台
 * 5.关闭资源
 */
public class UDPRece {
    public static void main(String[] args) throws Exception{
        //1.创建udpsocket服务,建立端点
        DatagramSocket ds = new DatagramSocket(10001);
        //2.定义一个数据包存储接收到的字节数据
        while (true) {
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            //3.通过服务的receive方法将收到的数据存入数据包中
            ds.receive(dp);
            //4.通过数据包方法获取数据
            String ip = dp.getAddress().getHostAddress();
            String data = new String(dp.getData(), 0, dp.getLength());
            int port = dp.getPort();
            System.out.println("ip:" + ip + "\n" + "data:" + data + "\nport:" + port);
            //5.关闭资源
            //ds.close();
        }
    }
}
