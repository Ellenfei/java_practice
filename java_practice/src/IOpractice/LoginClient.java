package IOpractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Ellen on 2017/6/19.
 * 客户端通过键盘录入用户名
 * 服务端对这个用户名进行校验
 * 最多登录三次
 */
public class LoginClient {
    public static void main(String[] args) throws Exception{
        //建立连接
        Socket socket = new Socket("ellenfei",10004);
        //键盘录入
        BufferedReader bufferR = new BufferedReader(new InputStreamReader(System.in));
        //获取socket中的输出流
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        //获取socket中的输入流
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //向服务端发送数据
        for(int i=0; i<3; i++) {
            String line = bufferR.readLine();
            if (line==null)
                break;
            out.println(line);

            String serLine = in.readLine();
            System.out.println("server:" + serLine);
            if (serLine.contains("welcome"))
                break;
        }
        bufferR.close();
        socket.close();
    }

}
