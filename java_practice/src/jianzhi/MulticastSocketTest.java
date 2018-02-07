package jianzhi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

/**
 * Created by Ellen on 2018/1/19.
 */
public class MulticastSocketTest implements Runnable {
    public static void main(String[] args) {

    }

    //多点广播地址
    private static final int BROADCAST_PORT = 3000;
    private static final String BROADCAST_IP = "127.0.0.1";
    //定义数据报大小
    private static final int DATA_LEN = 4096;
    //定义MulticastSocket实例
    private MulticastSocket socket = null;
    private InetAddress broadcastAddress = null;
    private Scanner scan = null;
    //定义接收网络数据的字节数组
    private byte[] inBuff = new byte[DATA_LEN];
    //以指定字节数组创建准备接收数据的datagrampacket对象
    private DatagramPacket inPacket = new DatagramPacket(inBuff, 0, inBuff.length);
    //用于发送的datagrampacket
    private DatagramPacket outPacket = null;
    public void init() throws IOException {
        //创建键盘输入流
        scan = new Scanner(System.in);
        //用于创建发送、接收数据的multicastSocket对象
        socket = new MulticastSocket(BROADCAST_PORT);
        broadcastAddress = InetAddress.getByName(BROADCAST_IP);
        //将socket加入到指定的多点广播地址
        socket.joinGroup(broadcastAddress);
        //设置本multicastsocket发送的数据会被回送到自身
        socket.setLoopbackMode(false);
        //初始化发送datagrampacket
        outPacket = new DatagramPacket(new byte[0], 0, broadcastAddress, BROADCAST_PORT);
        //启动本实例的run()方法作为本线程执行体的线程
        new Thread(this).start();
        //不断从键盘读取
        while (scan.hasNextLine()) {
            byte[] buff = scan.nextLine().getBytes();
            outPacket.setData(buff);
            //发送数据
            socket.send(outPacket);
        }
        socket.close();
    }
    @Override
    public void run() {
        try {
            while (true) {
                //读取socket中的数据，放入inPacket封装的字节数组中
                socket.receive(inPacket);
                System.out.println("聊天信息："+new String(inBuff, 0, inPacket.getLength()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            try {
                if (socket!=null) {
                    socket.leaveGroup(broadcastAddress);
                    socket.close();
                }
                System.exit(1);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
