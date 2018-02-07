package jianzhi;

import IOpractice.ClientTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by Ellen on 2018/1/17.
 */
//�����ȡSocket��Ӧ�������е����ݣ��ӷ���˷��͹���������,����ӡ����
class ClientThread implements Runnable {
    private Socket s = null;
    BufferedReader br = null;
    public ClientThread(Socket s) throws IOException {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }
    @Override
    public void run() {
        try {
            String line = null;
            while ((line=br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//�����ȡ�û��ļ������룬�����û����������д��Socket��Ӧ���������
public class MyClient {
    public static void main(String[] args) throws IOException{
        Socket socket=new Socket("127.0.0.1",3000);
        //�ͻ��������̲߳��϶�ȡ���Է���˵�����
        new Thread(new ClientThread(socket)).start();
        PrintStream ps = new PrintStream(socket.getOutputStream());
        String line = null;
        //���ϴӼ��̶�ȡ����
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((line=br.readLine()) != null) {
            ps.println(line);
        }
    }
}
