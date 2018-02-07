package IOpractice;



import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Ellen on 2017/6/14.
 */
public class readIn {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int ch = in.read();
            //sb.append((char)ch);
            if (ch=='\n') {
                String s = sb.toString();
                if ("over".equals(s))
                    break;
                System.out.println(s);
                sb.delete(0,sb.length());
            } else {
                sb.append((char)ch);
            }
        }


    }
}
