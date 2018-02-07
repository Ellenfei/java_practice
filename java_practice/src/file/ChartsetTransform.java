package file;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * Created by ye on 2016/11/4.
 */
public class ChartsetTransform {
    public static void main(String[] args) throws CharacterCodingException {
        Charset charset = Charset.forName("GBK");
        CharsetEncoder encoder = charset.newEncoder();
        CharsetDecoder decoder = charset.newDecoder();

        CharBuffer cbuffer = CharBuffer.allocate(8);
        cbuffer.put('a');
        cbuffer.put('b');
        cbuffer.put('d');
        cbuffer.put('e');

        cbuffer.flip();
        //cbuffer.clear();
        ByteBuffer bbuffer = encoder.encode(cbuffer);
        for (int i = 0; i<bbuffer.capacity(); i++) {
            //bbuffer.flip();
            System.out.println(bbuffer.get(i));
            bbuffer.clear();
            System.out.println(cbuffer.get(i));
            cbuffer.clear();
        }

        System.out.println(decoder.decode(bbuffer));

    }
}
