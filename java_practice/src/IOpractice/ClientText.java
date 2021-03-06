package IOpractice;

import java.io.*;
import java.net.Socket;

/**
 * Created by Ellen on 2017/6/19.
 */
public class ClientText {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("ellenfei",10007);
        //读取文件
        BufferedReader bufferR = new BufferedReader(new FileReader(
                "E:\\Ellen_study\\java_practice\\src\\IOpractice\\ClientText.java"));
        //发送给服务端
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        //时间戳
        //long time = System.currentTimeMillis();
        //out.println(time);
        String line;
        while ((line=bufferR.readLine())!=null) {
            out.println(line);
        }
        socket.shutdownOutput();//关闭客户端输出流，相当于给流中加入一个-1结束标记
        //out.println("over");自定义结束标记
        System.out.println("客户端发送数据完成");
        //接收服务端发送的消息
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str = in.readLine();
        System.out.println("server:"+str);
        bufferR.close();
        socket.close();
    }
}
