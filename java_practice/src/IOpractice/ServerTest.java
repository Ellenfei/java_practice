package IOpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Ellen on 2017/6/20.
 */
public class ServerTest {
    private ServerSocket ss;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    public ServerTest() {
        try {
            ss = new ServerSocket(10002);
            socket = ss.accept();
            String ip = socket.getInetAddress().getHostAddress();
            System.out.println("ip:"+ip);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            String line = null;
            //System.out.println("before");
            while((line=in.readLine())!=null) {
                System.out.println("client say: "+line);
                out.println("receive!!!!");
            }
            System.out.println("after");

           // out.println("receive!!!!");

            socket.close();
            ss.close();
        } catch (IOException e) {
            out.println("wrong");
        }
    }
    public static void main(String[] args) throws Exception{
        new ServerTest();
    }
}
