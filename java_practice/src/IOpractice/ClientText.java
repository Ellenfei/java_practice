package IOpractice;

import java.io.*;
import java.net.Socket;

/**
 * Created by Ellen on 2017/6/19.
 */
public class ClientText {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("ellenfei",10007);
        //��ȡ�ļ�
        BufferedReader bufferR = new BufferedReader(new FileReader(
                "E:\\Ellen_study\\java_practice\\src\\IOpractice\\ClientText.java"));
        //���͸������
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        //ʱ���
        //long time = System.currentTimeMillis();
        //out.println(time);
        String line;
        while ((line=bufferR.readLine())!=null) {
            out.println(line);
        }
        socket.shutdownOutput();//�رտͻ�����������൱�ڸ����м���һ��-1�������
        //out.println("over");�Զ���������
        System.out.println("�ͻ��˷����������");
        //���շ���˷��͵���Ϣ
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str = in.readLine();
        System.out.println("server:"+str);
        bufferR.close();
        socket.close();
    }
}