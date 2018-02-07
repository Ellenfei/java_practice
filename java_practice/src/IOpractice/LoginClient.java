package IOpractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Ellen on 2017/6/19.
 * �ͻ���ͨ������¼���û���
 * ����˶�����û�������У��
 * ����¼����
 */
public class LoginClient {
    public static void main(String[] args) throws Exception{
        //��������
        Socket socket = new Socket("ellenfei",10004);
        //����¼��
        BufferedReader bufferR = new BufferedReader(new InputStreamReader(System.in));
        //��ȡsocket�е������
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        //��ȡsocket�е�������
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //�����˷�������
        for(int i=0; i<3; i++) {
            String line = bufferR.readLine();
            if (line==null)
                break;
            out.println(line);

            String serLine = in.readLine();
            System.out.println("server:" + serLine);
            if (serLine.contains("welcome"))
                break;
        }
        bufferR.close();
        socket.close();
    }

}
