package IOpractice;

import java.io.IOException;
import java.net.*;

/**
 * Created by Ellen on 2017/6/16.
 * ����ͨ��UDP���䷽ʽ����һ���������ݷ��ͳ�ȥ
 * ���裺
 * 1.����udpsocket����
 * 2.�ṩ���ݣ������ݷ�װ�����ݰ���
 * 3.ͨ��socket����ķ��͹��ܣ������ݰ�����ȥ
 * 4.�ر���Դ
 */


public class UDPDemo {
    public static void main(String[] args) {

        try {
            //����udp����
            DatagramSocket ds = new DatagramSocket();
            //ȷ�����ݣ�����װ�����ݰ�

            byte[] data = "udp hello".getBytes();
            DatagramPacket dp = new DatagramPacket(data,data.length, InetAddress.getByName("192.168.56.1"),10000);
            //��������
            ds.send(dp);
            //�ر���Դ
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
