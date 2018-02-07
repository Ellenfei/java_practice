package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by ye on 2016/11/1.
 */
public class PrintStreamTest {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("E:\\Ellen_study\\java_practice\\src\\file\\test.txt");
        PrintStream ps = new PrintStream(fos);
        ps.println("ÄãºÃ£¡");
        ps.println(new PrintStreamTest());
        ps.close();
    }
}
