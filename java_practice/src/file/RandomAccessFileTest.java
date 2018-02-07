package file;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by ye on 2016/11/3.
 */
public class RandomAccessFileTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile rsf = new RandomAccessFile("E:\\Ellen_study\\java_practice\\src\\file\\" +
                "RandomAccessFileTest.java","r");
        rsf.seek(300);
        byte[] bbuf = new byte[1024];
        int hasRead = 0;
        while ((hasRead = rsf.read(bbuf)) > 0) {
            System.out.println(new String(bbuf,0,hasRead));
        }

        RandomAccessFile rsfw = new RandomAccessFile("E:\\Ellen_study\\java_practice\\src\\file\\" +
                "random.txt","rw");
        rsfw.seek(rsfw.length());
        rsfw.write("zhuijiade ".getBytes());
        rsfw.close();
    }
}
