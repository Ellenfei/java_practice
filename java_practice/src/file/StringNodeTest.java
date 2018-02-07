package file;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by ye on 2016/11/1.
 */
public class StringNodeTest {
    public static void main(String[] args) throws IOException {
        String src = "����������һ���Ҹ�����\n"+
                "ι��������������....\n";
        StringReader sr = new StringReader(src);
        char[] cbuf = new char[32];
        int hasRead = 0;
        while ((hasRead = sr.read(cbuf)) >0 ) {
            System.out.print(new String(cbuf,0,hasRead));
        }

        StringWriter sw = new StringWriter();
        sw.write("�������������ʳ���߲�\n");
        sw.write("����һ�����ӣ��泯�󺣣���ů����\n");
        System.out.print(sw.toString());
        sr.close();
        sw.close();
    }
}
