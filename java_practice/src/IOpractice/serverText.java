package IOpractice;

import com.sun.corba.se.spi.activation.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Ellen on 2017/6/19.
 */
public class serverText {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(10007);
        Socket socket = server.accept();
        String ip = socket.getInetAddress().getHostAddress();
        System.out.println("ip:"+ip);
        //��ȡlong����

        //��ȡ�ͻ��˷�������
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //�����д���ļ�
        //BufferedWriter out = new BufferedWriter(new FileWriter("server.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("server.txt"),true);
        System.out.println("����˿�ʼ��������");
        String line;
        while((line=in.readLine())!=null) {
            //if ("over".equals(line))
            //    break;
            out.println(line);
            //out.write(line);
            //out.newLine();
            //out.flush();
        }
        System.out.println("����˽����������");
        //�ͻ��˷���xinix
        PrintWriter outClient = new PrintWriter(socket.getOutputStream(),true);
        outClient.println("�ϴ��ɹ�����");
        out.close();
        socket.close();
        server.close();
    }
}
