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

//����ÿ���߳�ͨ�ŵ��߳���
class ServerSocketThread implements Runnable {
    Socket s = null;
    //����socket��������
    BufferedReader br = null;
    public ServerSocketThread(Socket s) throws IOException{
        this.s = s;
        //��ʼ��socket��Ӧ��������
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }
    @Override
    public void run() {
        try {
            String content = null;
            while ((content=readFromClient()) != null) {
                //����sockets�е�ÿ���ͻ��ˣ���������Ϣ
                for (Socket socket : MyServer.sockets) {
                    PrintStream ps = new PrintStream(socket.getOutputStream());
                    ps.println(content);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //�����ȡ�ͻ������ݵķ���
    public String readFromClient() {
        try {
            return br.readLine();
        } catch (IOException e) {
            MyServer.sockets.remove(s);
        }
        return null;
    }
}

//����ServerSocket����������
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
