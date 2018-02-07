package file;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;


/**
 * Created by ye on 2016/11/3.
 */
public class FileChannelTest {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\Ellen_study\\java_practice\\src\\file\\FileChannelTest.java");
        FileChannel inChannel = new FileInputStream(file).getChannel();
        FileChannel outChannel = new FileOutputStream("E:\\Ellen_study\\java_practice\\src\\file\\" +
                "a.txt").getChannel();
        ByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
       // Charset charset = Charset.forName("GBK");
        outChannel.write(buffer);
       // CharsetDecoder decoder = charset.newDecoder();
        //CharBuffer charBuffer = decoder.decode(buffer);
       // System.out.println(charBuffer);
        System.out.println(buffer);

    }
}
