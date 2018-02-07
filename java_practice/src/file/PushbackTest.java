package file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

/**
 * Created by ye on 2016/11/1.
 */
public class PushbackTest {
    public static void main(String[] args) throws IOException {
        PushbackReader pr = new PushbackReader(new FileReader("E:\\Ellen_study\\java_practice\\src\\file\\" +
                "PushbackTest.java"),64);
        char[] cbuf = new char[32];
        String lastContent = null;
        int hasRead = 0;
        while ((hasRead = pr.read(cbuf)) > 0 ) {
            String content = new String(cbuf,0,hasRead);
            int targetIndex = 0;
            if ((targetIndex = (lastContent+content).indexOf("new PushbackReader")) > 0) {
                pr.unread((lastContent+content).toCharArray());
                if (targetIndex > 32) {
                    cbuf = new char[targetIndex];
                }
                pr.read(cbuf,0,targetIndex);
                System.out.print(new String(cbuf, 0, targetIndex));
                System.exit(0);
            }
            else {
                System.out.print(lastContent);
                lastContent = content;
            }
        }
    }
}
