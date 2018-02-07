package IOpractice;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Ellen on 2017/6/19.
 */

class ServerThread implements Runnable {
    private Socket socket;
    public ServerThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        //读取客户端数据信息
        String ip = socket.getInetAddress().getHostAddress();
        System.out.println("ip:" + ip);
        try {
            for (int i=0; i<3; i++) {
                //读取流
                BufferedReader buffIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //写入流
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                String name = buffIn.readLine();
                if (name==null)
                    break;
                //读取user文件，校验用户
                BufferedReader buffFile = new BufferedReader(new FileReader("E:\\Ellen_study\\java_practice\\user.txt"));
                String line;
                //定义标记
                boolean flag = false;
                while((line=buffFile.readLine())!=null) {
                    if (name.equals(line)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    System.out.println(name+"已经登录");
                    out.println(name + ",  welcome to login....");
                    break;
                } else {
                    System.out.println(name+"尝试登陆......");
                    out.println(name+"用户名不存在");
                }
            }
            socket.close();
        } catch (IOException e) {
            throw new  RuntimeException(ip+"  failed");
        }

    }
}

public class LoginServer {
    public static void main(String[] args) throws Exception{
        //建立socket服务端
        ServerSocket server = new ServerSocket(10004);

        while (true) {
            //与客户端连接
            Socket socket = server.accept();
            new Thread(new ServerThread(socket)).start();
        }
    }
}
