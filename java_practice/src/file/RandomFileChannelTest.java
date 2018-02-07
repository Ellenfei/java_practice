package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by ye on 2016/11/4.
 */
public class RandomFileChannelTest {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\Ellen_study\\java_practice\\src\\file\\a.txt");
        File f = new File("E:\\Ellen_study\\java_practice\\src\\file\\poem.txt");
        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        RandomAccessFile raf1 = new RandomAccessFile(f,"rw");
        FileChannel fileChannel = raf.getChannel();
        FileChannel fileChannel1 = raf1.getChannel();
        ByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
        ByteBuffer buffer1 = fileChannel.map(FileChannel.MapMode.READ_ONLY,0,f.length());
        fileChannel.position(file.length());
        fileChannel.write(buffer);
    }
}
