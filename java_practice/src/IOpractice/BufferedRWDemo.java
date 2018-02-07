package IOpractice;

import java.io.*;

/**
 * Created by Ellen on 2017/6/5.
 */
public class BufferedRWDemo {
    public static void main(String[] args) {
        BufferedReader bufr = null;
        BufferedWriter bufw = null;

        try {
            bufr = new BufferedReader(new FileReader("E:\\Ellen_study\\java_practice\\src\\IOpractice\\BufferedRWDemo.java"));
            bufw = new BufferedWriter(new FileWriter("E:\\Ellen_study\\java_practice\\src\\IOpractice\\copyBuffered.txt"));
            String line ;
            while((line = bufr.readLine())!=null) {
                bufw.write(line);
                bufw.flush();
                bufw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();;
        }finally {
            try {
                if (bufr!=null)
                 bufr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bufw!=null)
                    bufw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
