package jianzhi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Ellen on 2018/1/19.
 */
public class UDPServer {
    public static final int PORT = 3000;
    private static final int DATA_LEN = 4096; //定义每个数据报的大小
    byte[] inBuff = new byte[DATA_LEN]; //定义接收网络数据的字节数组
    //以指定的字节数组创建接收数据的datagrampacket对象
    private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
    //定义一个用于发送的datagrampacket对象
    private DatagramPacket outPacket = null;
    private String[] books = {"疯狂Java讲义","轻量级....实践","疯狂Android讲义"};
    public void init() throws IOException {
        try (
                //创建datagrampocket对象
                DatagramSocket socket = new DatagramSocket(PORT);
                ){
            //采用循环接收数据
            for (int i=0; i<1000; i++) {
                //读取socket中的数据，放入inPacket封装的数组里
                socket.receive(inPacket);
                //判断inPacket.getData()和inBuff是否是同一数组
                System.out.println(inPacket.getData()==inBuff);
                //输出
                System.out.println(new String(inBuff, 0, inPacket.getLength()));
                //发送数据
                byte[] sendData = books[i%3].getBytes();
                outPacket = new DatagramPacket(sendData, sendData.length,
                        inPacket.getSocketAddress());
                socket.send(outPacket);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        new UDPServer().init();
    }
}
