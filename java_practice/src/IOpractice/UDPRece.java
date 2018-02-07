package IOpractice;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Ellen on 2017/6/16.
 * ���󣺶���һ��Ӧ�ó������ڽ���UDPЭ�鴫������ݲ�����
 * ���裺
 * 1.����udpsocket����ͨ�������һ���˿ڣ�����������Ӧ�ó�����һ�����ֱ�ʶ
 * 2.����һ�����ݰ����洢���յ����ֽ�����
 * 2.ͨ��socket�����е�receive�������յ������ݴ����Ѷ���õ����ݰ���
 * 4.ͨ�����ݰ���������й��ܣ�����Щ��ͬ������ȡ������ӡ�ڿ���̨
 * 5.�ر���Դ
 */
public class UDPRece {
    public static void main(String[] args) throws Exception{
        //1.����udpsocket����,�����˵�
        DatagramSocket ds = new DatagramSocket(10001);
        //2.����һ�����ݰ��洢���յ����ֽ�����
        while (true) {
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            //3.ͨ�������receive�������յ������ݴ������ݰ���
            ds.receive(dp);
            //4.ͨ�����ݰ�������ȡ����
            String ip = dp.getAddress().getHostAddress();
            String data = new String(dp.getData(), 0, dp.getLength());
            int port = dp.getPort();
            System.out.println("ip:" + ip + "\n" + "data:" + data + "\nport:" + port);
            //5.�ر���Դ
            //ds.close();
        }
    }
}
