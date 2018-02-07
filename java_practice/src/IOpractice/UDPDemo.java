package IOpractice;

import java.io.IOException;
import java.net.*;

/**
 * Created by Ellen on 2017/6/16.
 * 需求：通过UDP传输方式，将一段文字数据发送出去
 * 步骤：
 * 1.建立udpsocket服务
 * 2.提供数据，将数据封装到数据包中
 * 3.通过socket服务的发送功能，将数据包发出去
 * 4.关闭资源
 */


public class UDPDemo {
    public static void main(String[] args) {

        try {
            //创建udp服务
            DatagramSocket ds = new DatagramSocket();
            //确定数据，并封装成数据包

            byte[] data = "udp hello".getBytes();
            DatagramPacket dp = new DatagramPacket(data,data.length, InetAddress.getByName("192.168.56.1"),10000);
            //发送数据
            ds.send(dp);
            //关闭资源
            ds.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
