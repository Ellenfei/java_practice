package IOpractice;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Ellen on 2017/6/14.
 */
public class IPDemo {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println(inetAddress.toString());
            System.out.println(inetAddress.getHostAddress());
            System.out.println(inetAddress.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
