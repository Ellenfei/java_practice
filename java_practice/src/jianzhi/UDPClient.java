package jianzhi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Created by Ellen on 2018/1/19.
 */
public class UDPClient {
    //指定发送数据报的目的地
    private static final int DEST_PORT = 3000;
    private static final String DEST_IP = "127.0.0.1";
    //定义每个数据报的大小最大为4kb
    private static final int DATA_LEN = 4096;
    //定义接收网络数据的字节数组
    byte[] inBuff = new byte[DATA_LEN];
    //以指定的字节数组创建准备接收数据的DatagramPacket对象
    DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
    //定义一个用于发送数据的datagrampacket
    DatagramPacket outPacket = null;

    public void init() throws IOException {
        try (
                //创建客户端的datagramsocket， 使用随机端口
                DatagramSocket socket = new DatagramSocket()
                ) {
            //初始化发送的datagrampacket
            outPacket = new DatagramPacket(new byte[0], 0,
                    InetAddress.getByName(DEST_IP), DEST_PORT);
            //创建键盘输入
            Scanner in = new Scanner(System.in);
            //不断读取键盘输入
            while (in.hasNextLine()) {
                //转换为字节数组
                byte[] buff = in.nextLine().getBytes();
                //send
                outPacket.setData(buff);
                socket.send(outPacket);
                //读取
                socket.receive(inPacket);
                System.out.println(new String(inBuff, 0, inPacket.getLength()));
            }
        }

    }
    public static void main(String[] args) throws IOException{
        new UDPClient().init();
    }
}
