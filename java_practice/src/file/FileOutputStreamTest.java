package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ye on 2016/11/1.
 */
public class FileOutputStreamTest {
    public static void main(String[] args) {
        try(
                FileInputStream fis = new FileInputStream("E:\\Ellen_study\\java_practice\\src\\file\\" +
                "FileOutputStreamTest.java");
                FileOutputStream fos = new FileOutputStream("newFos.txt") )
        {


            byte[] bbuf = new byte[32];
            int hasRead;
            while ((hasRead = fis.read(bbuf)) > 0) {
                fos.write(bbuf, 0, hasRead);
            }
            fos.close();
            fis.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
