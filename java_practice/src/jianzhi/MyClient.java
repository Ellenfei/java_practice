package jianzhi;

import IOpractice.ClientTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by Ellen on 2018/1/17.
 */
//负责读取Socket对应输入流中的数据，从服务端发送过来的数据,并打印出来
class ClientThread implements Runnable {
    private Socket s = null;
    BufferedReader br = null;
    public ClientThread(Socket s) throws IOException {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }
    @Override
    public void run() {
        try {
            String line = null;
            while ((line=br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//负责读取用户的键盘输入，并将用户输入的数据写入Socket对应的输出流中
public class MyClient {
    public static void main(String[] args) throws IOException{
        Socket socket=new Socket("127.0.0.1",3000);
        //客户端启动线程不断读取来自服务端的数据
        new Thread(new ClientThread(socket)).start();
        PrintStream ps = new PrintStream(socket.getOutputStream());
        String line = null;
        //不断从键盘读取输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((line=br.readLine()) != null) {
            ps.println(line);
        }
    }
}
