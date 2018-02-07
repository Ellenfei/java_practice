package IOpractice;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Ellen on 2017/6/19.
 */
public class PicClient {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("ellenfei",10005);
        FileInputStream fis = new FileInputStream("E:\\Ellen_study\\java_practice\\1.tif");
        OutputStream out = socket.getOutputStream();
        byte[] buff = new byte[1024];
        int len;
        while((len=fis.read(buff))!=-1) {
            out.write(buff,0,len);
        }
        //告诉服务端数据已经写完
        socket.shutdownOutput();
        InputStream in = socket.getInputStream();
        byte[] bufIn = new byte[1024];
        int length =in.read(bufIn);
        System.out.println(new String(bufIn,0,length));
    }
}
