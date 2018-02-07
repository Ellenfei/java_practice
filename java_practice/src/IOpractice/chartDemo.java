package IOpractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Ellen on 2017/6/16.
 * ��дһ���������---��+������
 * ��Ҫ���̼߳�����һ���߳̿����գ�һ���߳̿��Ʒ�
 *
 * ��Ϊ�շ�������һ�£�����Ҫ��������run��������װ����ͬ������
 */

class send implements Runnable {

    private DatagramSocket ds;
    public send(DatagramSocket ds) {
        this.ds = ds;
    }
    @Override
    public void run() {
        try {
            BufferedReader buffR = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while((line=buffR.readLine())!=null) {
                if ("over".equals(line))
                    break;
                byte[] data = line.getBytes();
                DatagramPacket dp = new DatagramPacket(data,data.length, InetAddress.getByName("ellenfei"),10006);
                ds.send(dp);
            }
            ds.close();
        }catch (Exception e){
            throw new RuntimeException("send  failed");
        }
    }
}

class rece implements Runnable {

    private DatagramSocket ds;
    public rece(DatagramSocket ds) {
        this.ds = ds;
    }
    @Override
    public void run() {
        try {
            while(true) {
                byte[] buf  = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf,buf.length);
                ds.receive(dp);
                String ip = dp.getAddress().getHostAddress();
                String data = new String(dp.getData(),0,dp.getLength());
                System.out.println("ip:"+ip+"\ndata:"+data);

            }
        }catch(Exception e) {
            throw new RuntimeException("receive  failed");
        }
    }
}

public class chartDemo {
    public static void main(String[] args) throws Exception{
        DatagramSocket sendSocket = new DatagramSocket();
        DatagramSocket receSocket = new DatagramSocket(10006);
        new Thread(new send(sendSocket)).start();
        new Thread(new rece(receSocket)).start();
    }
}
