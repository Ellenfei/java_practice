package IOpractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by Ellen on 2017/6/18.
 * ���󣺽���һ���ı�ת�����������ͻ��˸�����˷����ı�������˽��ı�ת�ɴ�д���ظ��ͻ��ˣ�
 * �ͻ�������over����
 * �����ı����ݣ�ѡ���ַ���
 * ���裺
 * 1.��������
 * 2.��ȡ����¼��
 * 3.���͸������
 * 4.��ȡ����˴�д����
 * 5.�������ر���Դ
 * ���⣺�ͻ��������˶���Ī���ĵȴ�----�ͻ��������˶�������ʽ��������Щ����û�ж����������
 */
public class clientTCP {
    public static void main(String[] args) throws Exception{
        //�����ͻ��ˣ������ȡ����
        Socket client = new Socket("ellenfei",10008);
        BufferedReader bufferR = new BufferedReader(new InputStreamReader(System.in));
        //����Ŀ�ģ�������д��socket�����
        //PrintWriter out = new PrintWriter(client.getOutputStream(),true)
        BufferedWriter bufferOut = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        //����socket��ȡ��
        BufferedReader bufferIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String line;
        while ((line=bufferR.readLine())!=null) {
            if ("over".equals(line))
                break;
            //out.print(line);
            bufferOut.write(line,0,line.length());
            bufferOut.newLine();
            bufferOut.flush();

            String str = bufferIn.readLine();
            System.out.println("server:"+str);
        }
        bufferR.close();
        client.close();
    }
}
