package file;

import java.nio.CharBuffer;

/**
 * Created by ye on 2016/11/3.
 */
public class BufferTest {
    public static void main(String[] args) {
        CharBuffer cb = CharBuffer.allocate(16);
        System.out.println(cb.position() + "  " + cb.limit() + "  " + cb.capacity());
        cb.put("a");
        cb.put("b");
        cb.put("c");
        System.out.println(cb.position() + "  " + cb.limit() + "  " + cb.capacity());
        cb.flip();
        System.out.println(cb.position() + "  " + cb.limit() + "  " + cb.capacity());
        cb.clear();
        System.out.println( cb.get(2)+cb.position() + "  " + cb.limit() + "  " + cb.capacity());
    }
}
