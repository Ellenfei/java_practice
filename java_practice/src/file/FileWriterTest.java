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
        fileWriter.write("��ɪ�޶���ʮ�ҡ�һ��һ��˼���ꡣ\r\n");
        fileWriter.write("ׯ�������Ժ��������۴����жž顣\r\n");
        //fileWriter.flush();
        fileWriter.close();
    }
}
