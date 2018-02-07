package IOpractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Ellen on 2017/6/16.
 */
public class UDPSend {
    public static void main(String[] args) throws Exception{
        DatagramSocket ds = new DatagramSocket();

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String line ;

        while ((line=buffer.readLine())!=null) {
            if ("over".equals(line))
                break;
            byte[] data = line.getBytes();
            DatagramPacket dp = new DatagramPacket(data,data.length, InetAddress.getByName("ellenfei"),10001);
            ds.send(dp);
        }
        ds.close();
    }
}
