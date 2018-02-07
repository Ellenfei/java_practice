package IOpractice;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Ellen on 2017/6/19.
 */
class PicThread implements Runnable{
    private Socket socket;
    public PicThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        int count=1;
        String ip = socket.getInetAddress().getHostAddress();
        try {

            System.out.println("ip:"+ip);
            InputStream in = socket.getInputStream();

            File file = new File(ip+"("+count+").jpg");
            //FileOutputStream fos = new FileOutputStream(ip+"("+count+").jpg");
            while(file.exists()) {
                file = new File(ip+"("+(count++)+").jpg");
            }

            FileOutputStream fos = new FileOutputStream(file);
            byte[] buff = new byte[1024];
            int len;
            while ((len=in.read(buff))!=-1) {
                fos.write(buff,0,len);
            }
            OutputStream out = socket.getOutputStream();
            out.write("server:success....".getBytes());
            fos.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(ip+":failed....");
        }
    }
}
public class PicServer {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(10005);
        while(true) {
            Socket s = server.accept();
            new Thread(new PicThread(s)).start();
        }
    }
}
