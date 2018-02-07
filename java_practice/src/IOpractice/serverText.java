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
        //读取long类型

        //读取客户端发送数据
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //服务端写进文件
        //BufferedWriter out = new BufferedWriter(new FileWriter("server.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("server.txt"),true);
        System.out.println("服务端开始接收数据");
        String line;
        while((line=in.readLine())!=null) {
            //if ("over".equals(line))
            //    break;
            out.println(line);
            //out.write(line);
            //out.newLine();
            //out.flush();
        }
        System.out.println("服务端接收数据完成");
        //客户端返回xinix
        PrintWriter outClient = new PrintWriter(socket.getOutputStream(),true);
        outClient.println("上传成功！！");
        out.close();
        socket.close();
        server.close();
    }
}
