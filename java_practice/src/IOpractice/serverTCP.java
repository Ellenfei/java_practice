package IOpractice;

import systemtest.SystemTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Ellen on 2017/6/18.
 */
public class serverTCP {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(10008);
        Socket socket = server.accept();
        String ip = socket.getInetAddress().getHostAddress();
        System.out.println("ip:" + ip);
        //Դ
        BufferedReader bufferR = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //Ŀ�ģ���д����д�뵽socket����������ͻ���
        BufferedWriter bufferOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String line;

        while((line=bufferR.readLine())!=null) {
            System.out.println(line);
            bufferOut.write(line.toUpperCase());
            bufferOut.newLine();
            bufferOut.flush();
        }
        socket.close();
        server.close();
    }
}
