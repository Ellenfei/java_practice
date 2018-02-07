package IOpractice;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Ellen on 2017/6/20.
 */
public class URLDemo {
    public static void main(String[] args) throws Exception{
        URL url = new URL("http://www.baidu.cn");
        URLConnection con = url.openConnection();
        System.out.println(con);
        InputStream in = con.getInputStream();
        byte[] buff = new byte[1024];
        int len = in.read(buff);
        System.out.println(new String(buff,0,len));
    }
}
