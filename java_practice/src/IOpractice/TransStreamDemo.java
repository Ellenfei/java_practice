package IOpractice;

import systemtest.SystemTest;

import java.io.*;

/**
 * Created by Ellen on 2017/6/14.
 * 1.需求：把键盘录入的数据存储到一个文件中
 * 2.需求：将一个文件的数据打印到控制台
 */
public class TransStreamDemo {
    public static void main(String[] args) throws IOException{
        //键盘最常用写法
        BufferedReader bufferR = new BufferedReader(new InputStreamReader
                (new FileInputStream("E:\\Ellen_study\\java_practice\\src\\IOpractice\\out.txt")));
        //BufferedReader bufferR = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferW = new BufferedWriter(new OutputStreamWriter(System.out));

       /* BufferedWriter bufferW = new BufferedWriter(new OutputStreamWriter
                (new FileOutputStream("E:\\Ellen_study\\java_practice\\src\\IOpractice\\out.txt")));*/

        String line ;
        while ((line=bufferR.readLine())!=null) {
            if ("over".equals(line))
                break;
            bufferW.write(line.toUpperCase());
            bufferW.newLine();
            bufferW.flush();
        }
        bufferW.close();
        bufferR.close();
    }
}
