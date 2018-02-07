package IOpractice;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Ellen on 2017/6/19.
 */
public class ServerDemo {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(10001);
        Socket socket = server.accept();
        String ip = socket.getInetAddress().getHostAddress();
        System.out.println("ip:"+ip);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        out.println("¿Í»§¶Ë£¬ÄãºÃ");
        System.out.println("hello");
        socket.close();
        server.close();

    }
}
