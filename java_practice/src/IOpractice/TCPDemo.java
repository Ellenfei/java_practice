package IOpractice;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Ellen on 2017/6/18.
 *
 * 利用TCP协议实现客户端与服务端的通信
 *
 */

class TCPClient implements Runnable{
    private Socket socket;
    public TCPClient (Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            OutputStream out = socket.getOutputStream();
            out.write("hello server".getBytes());

            InputStream in = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len = in.read(buffer);
            System.out.println(new String(buffer,0,len));
        } catch (IOException e) {
           throw new RuntimeException("client failed");
        }
    }
}

class TCPServer implements Runnable{
    private ServerSocket serverSocket;
    public TCPServer(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }
    @Override
    public void run() {
        try {
            while(true) {
                Socket s = serverSocket.accept();
                String ip = s.getInetAddress().getHostAddress();
                System.out.println("IP:" + ip);
                InputStream in = s.getInputStream();
                byte[] buffer = new byte[1024];
                int len = in.read(buffer);
                System.out.println(new String(buffer, 0, len));

                //return information
                OutputStream out = s.getOutputStream();
                out.write("server receives".getBytes());
            }
           // s.close();
            //serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("server failed");
        }
    }
}

public class TCPDemo {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("192.168.56.1",10008);
        ServerSocket serverSocket = new ServerSocket(10008);
        new Thread(new TCPServer(serverSocket)).start();
        new Thread(new TCPClient(socket)).start();
    }
}
