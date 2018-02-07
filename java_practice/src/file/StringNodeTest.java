package file;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by ye on 2016/11/1.
 */
public class StringNodeTest {
    public static void main(String[] args) throws IOException {
        String src = "从明天起做一个幸福的人\n"+
                "喂马，劈柴，周游世界....\n";
        StringReader sr = new StringReader(src);
        char[] cbuf = new char[32];
        int hasRead = 0;
        while ((hasRead = sr.read(cbuf)) >0 ) {
            System.out.print(new String(cbuf,0,hasRead));
        }

        StringWriter sw = new StringWriter();
        sw.write("从明天起关心粮食和蔬菜\n");
        sw.write("我有一所房子，面朝大海，春暖花开\n");
        System.out.print(sw.toString());
        sr.close();
        sw.close();
    }
}
