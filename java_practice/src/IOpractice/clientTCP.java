package IOpractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by Ellen on 2017/6/18.
 * 需求：建立一个文本转换服务器。客户端给服务端发送文本，服务端将文本转成大写返回给客户端，
 * 客户端输入over结束
 * 操作文本数据，选择字符流
 * 步骤：
 * 1.建立服务
 * 2.获取键盘录入
 * 3.发送给服务端
 * 4.获取服务端大写数据
 * 5.结束，关闭资源
 * 问题：客户端与服务端都在莫名的等待----客户端与服务端都有阻塞式方法，这些方法没有读到结束标记
 */
public class clientTCP {
    public static void main(String[] args) throws Exception{
        //建立客户端，定义读取键盘
        Socket client = new Socket("ellenfei",10008);
        BufferedReader bufferR = new BufferedReader(new InputStreamReader(System.in));
        //定义目的，将数据写入socket输出流
        //PrintWriter out = new PrintWriter(client.getOutputStream(),true)
        BufferedWriter bufferOut = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        //定义socket读取流
        BufferedReader bufferIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String line;
        while ((line=bufferR.readLine())!=null) {
            if ("over".equals(line))
                break;
            //out.print(line);
            bufferOut.write(line,0,line.length());
            bufferOut.newLine();
            bufferOut.flush();

            String str = bufferIn.readLine();
            System.out.println("server:"+str);
        }
        bufferR.close();
        client.close();
    }
}
