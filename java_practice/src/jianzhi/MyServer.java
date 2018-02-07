package jianzhi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ellen on 2018/1/17.
 */

//处理每个线程通信的线程类
class ServerSocketThread implements Runnable {
    Socket s = null;
    //处理socket的输入流
    BufferedReader br = null;
    public ServerSocketThread(Socket s) throws IOException{
        this.s = s;
        //初始化socket对应的输入流
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }
    @Override
    public void run() {
        try {
            String content = null;
            while ((content=readFromClient()) != null) {
                //遍历sockets中的每个客户端，并发送消息
                for (Socket socket : MyServer.sockets) {
                    PrintStream ps = new PrintStream(socket.getOutputStream());
                    ps.println(content);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //定义读取客户端数据的方法
    public String readFromClient() {
        try {
            return br.readLine();
        } catch (IOException e) {
            MyServer.sockets.remove(s);
        }
        return null;
    }
}

//创建ServerSocket监听的主类
public class MyServer {
    public static List<Socket> sockets = Collections.synchronizedList(new ArrayList<Socket>());
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(3000);
        while (true) {
            Socket s = ss.accept();
            sockets.add(s);
            new Thread(new ServerSocketThread(s)).start();
        }
    }
}
