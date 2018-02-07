package jianzhi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Ellen on 2018/1/19.
 */
public class UDPServer {
    public static final int PORT = 3000;
    private static final int DATA_LEN = 4096; //����ÿ�����ݱ��Ĵ�С
    byte[] inBuff = new byte[DATA_LEN]; //��������������ݵ��ֽ�����
    //��ָ�����ֽ����鴴���������ݵ�datagrampacket����
    private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
    //����һ�����ڷ��͵�datagrampacket����
    private DatagramPacket outPacket = null;
    private String[] books = {"���Java����","������....ʵ��","���Android����"};
    public void init() throws IOException {
        try (
                //����datagrampocket����
                DatagramSocket socket = new DatagramSocket(PORT);
                ){
            //����ѭ����������
            for (int i=0; i<1000; i++) {
                //��ȡsocket�е����ݣ�����inPacket��װ��������
                socket.receive(inPacket);
                //�ж�inPacket.getData()��inBuff�Ƿ���ͬһ����
                System.out.println(inPacket.getData()==inBuff);
                //���
                System.out.println(new String(inBuff, 0, inPacket.getLength()));
                //��������
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
