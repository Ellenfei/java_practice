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
    //ָ���������ݱ���Ŀ�ĵ�
    private static final int DEST_PORT = 3000;
    private static final String DEST_IP = "127.0.0.1";
    //����ÿ�����ݱ��Ĵ�С���Ϊ4kb
    private static final int DATA_LEN = 4096;
    //��������������ݵ��ֽ�����
    byte[] inBuff = new byte[DATA_LEN];
    //��ָ�����ֽ����鴴��׼���������ݵ�DatagramPacket����
    DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
    //����һ�����ڷ������ݵ�datagrampacket
    DatagramPacket outPacket = null;

    public void init() throws IOException {
        try (
                //�����ͻ��˵�datagramsocket�� ʹ������˿�
                DatagramSocket socket = new DatagramSocket()
                ) {
            //��ʼ�����͵�datagrampacket
            outPacket = new DatagramPacket(new byte[0], 0,
                    InetAddress.getByName(DEST_IP), DEST_PORT);
            //������������
            Scanner in = new Scanner(System.in);
            //���϶�ȡ��������
            while (in.hasNextLine()) {
                //ת��Ϊ�ֽ�����
                byte[] buff = in.nextLine().getBytes();
                //send
                outPacket.setData(buff);
                socket.send(outPacket);
                //��ȡ
                socket.receive(inPacket);
                System.out.println(new String(inBuff, 0, inPacket.getLength()));
            }
        }

    }
    public static void main(String[] args) throws IOException{
        new UDPClient().init();
    }
}
