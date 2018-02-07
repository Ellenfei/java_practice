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

    //���㲥��ַ
    private static final int BROADCAST_PORT = 3000;
    private static final String BROADCAST_IP = "127.0.0.1";
    //�������ݱ���С
    private static final int DATA_LEN = 4096;
    //����MulticastSocketʵ��
    private MulticastSocket socket = null;
    private InetAddress broadcastAddress = null;
    private Scanner scan = null;
    //��������������ݵ��ֽ�����
    private byte[] inBuff = new byte[DATA_LEN];
    //��ָ���ֽ����鴴��׼���������ݵ�datagrampacket����
    private DatagramPacket inPacket = new DatagramPacket(inBuff, 0, inBuff.length);
    //���ڷ��͵�datagrampacket
    private DatagramPacket outPacket = null;
    public void init() throws IOException {
        //��������������
        scan = new Scanner(System.in);
        //���ڴ������͡��������ݵ�multicastSocket����
        socket = new MulticastSocket(BROADCAST_PORT);
        broadcastAddress = InetAddress.getByName(BROADCAST_IP);
        //��socket���뵽ָ���Ķ��㲥��ַ
        socket.joinGroup(broadcastAddress);
        //���ñ�multicastsocket���͵����ݻᱻ���͵�����
        socket.setLoopbackMode(false);
        //��ʼ������datagrampacket
        outPacket = new DatagramPacket(new byte[0], 0, broadcastAddress, BROADCAST_PORT);
        //������ʵ����run()������Ϊ���߳�ִ������߳�
        new Thread(this).start();
        //���ϴӼ��̶�ȡ
        while (scan.hasNextLine()) {
            byte[] buff = scan.nextLine().getBytes();
            outPacket.setData(buff);
            //��������
            socket.send(outPacket);
        }
        socket.close();
    }
    @Override
    public void run() {
        try {
            while (true) {
                //��ȡsocket�е����ݣ�����inPacket��װ���ֽ�������
                socket.receive(inPacket);
                System.out.println("������Ϣ��"+new String(inBuff, 0, inPacket.getLength()));
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
