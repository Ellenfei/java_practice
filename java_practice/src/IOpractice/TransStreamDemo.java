package IOpractice;

import systemtest.SystemTest;

import java.io.*;

/**
 * Created by Ellen on 2017/6/14.
 * 1.���󣺰Ѽ���¼������ݴ洢��һ���ļ���
 * 2.���󣺽�һ���ļ������ݴ�ӡ������̨
 */
public class TransStreamDemo {
    public static void main(String[] args) throws IOException{
        //�������д��
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
