package file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by ye on 2016/11/5.
 */
public class FilesTest {
    public static void main(String[] args) throws IOException {
        Files.copy(Paths.get("E:\\Ellen_study\\java_practice\\src\\file\\" +
                "FilesTest.java"), new FileOutputStream("abc.txt"));
        System.out.println(Files.isHidden(Paths.get("E:\\Ellen_study\\java_practice\\src\\file\\" +
                "FilesTest.java")));
        List<String> lines = Files.readAllLines(Paths.get("E:\\Ellen_study\\java_practice\\src\\file\\" +
                "FilesTest.java"), Charset.forName("GBK"));
        System.out.println(lines);
    }
}
