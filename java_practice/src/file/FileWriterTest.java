package file;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by ye on 2016/11/1.
 */
public class FileWriterTest {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("E:\\Ellen_study\\java_practice\\src\\file\\poem.txt");
       // char[] cbuf = {'a','b','c'};
      //  fileWriter.write(cbuf);
        fileWriter.write("锦瑟无端五十弦。一弦一柱思华年。\r\n");
        fileWriter.write("庄生晓梦迷蝴蝶，望帝春心托杜鹃。\r\n");
        //fileWriter.flush();
        fileWriter.close();
    }
}
