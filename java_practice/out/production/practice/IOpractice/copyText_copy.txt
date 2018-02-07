package IOpractice;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Ellen on 2017/6/5.
 */
public class copyText {
    public static void main(String[] args) {
        copy();
    }

    //´ÓcÅÌ¶ÁÒ»¸ö×Ö·û£¬ÍùdÅÌÐ´Ò»¸ö×Ö·û
    public static void copy() {
        FileWriter fw = null;
        FileReader fr = null;
        try {
            fw = new FileWriter("E:\\Ellen_study\\java_practice\\src\\IOpractice\\copyText_copy.txt");
            fr = new FileReader("E:\\Ellen_study\\java_practice\\src\\IOpractice\\copyText.java");
            char[] ch = new char[1024];
            int len ;
            while((len = fr.read(ch))!=-1) {
                fw.write(ch,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException("duxieshibai");
        } finally {

                if (fr!=null)
                    try{
                        fr.close();
                        fw.close();
                    } catch (IOException e) {

                    }
            /*if (fr!=null)
                try{
                    fw.close();
                } catch (IOException e) {

                }*/

        }
    }
}
