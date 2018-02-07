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
        //��ȡ�ͻ���������Ϣ
        String ip = socket.getInetAddress().getHostAddress();
        System.out.println("ip:" + ip);
        try {
            for (int i=0; i<3; i++) {
                //��ȡ��
                BufferedReader buffIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //д����
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                String name = buffIn.readLine();
                if (name==null)
                    break;
                //��ȡuser�ļ���У���û�
                BufferedReader buffFile = new BufferedReader(new FileReader("E:\\Ellen_study\\java_practice\\user.txt"));
                String line;
                //������
                boolean flag = false;
                while((line=buffFile.readLine())!=null) {
                    if (name.equals(line)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    System.out.println(name+"�Ѿ���¼");
                    out.println(name + ",  welcome to login....");
                    break;
                } else {
                    System.out.println(name+"���Ե�½......");
                    out.println(name+"�û���������");
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
        //����socket�����
        ServerSocket server = new ServerSocket(10004);

        while (true) {
            //��ͻ�������
            Socket socket = server.accept();
            new Thread(new ServerThread(socket)).start();
        }
    }
}
