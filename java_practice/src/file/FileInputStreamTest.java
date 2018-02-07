package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by ye on 2016/11/1.
 */

/*   ×Ö½ÚÁ÷   */
public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        System.out.println(new File("").getAbsolutePath());
        FileInputStream fis = new FileInputStream("\\src\\file\\FileInputStreamTest.java");
        //E:\Ellen_study\java_practice\src\file\
        byte[] bbuf = new byte[1024];
        int hasRead = 0;
        while ((hasRead = fis.read(bbuf)) > 0) {
            System.out.print(new String(bbuf,0,hasRead));
        }
        fis.close();
    }
}
