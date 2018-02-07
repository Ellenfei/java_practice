package file;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by ye on 2016/11/4.
 */
public class ReadFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\Ellen_study\\java_practice\\src\\file\\ReadFile.java");
        FileChannel channel = fis.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(256);
        while (channel.read(buffer) != -1) {
            buffer.flip();
            Charset charset = Charset.forName("GBK");
            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer charBuffer = decoder.decode(buffer);
            System.out.println(charBuffer);
            buffer.clear();
        }
    }
}
