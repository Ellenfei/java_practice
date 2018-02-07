package IOpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Ellen on 2017/6/20.
 */
public class ClientTest {
    private Socket client;
    private BufferedReader bufferR;
    private PrintWriter out;
    private BufferedReader in;
    public ClientTest() {
        try {
            client = new Socket("ellenfei",10002);
            bufferR = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(client.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String line = null;
            while ((line = bufferR.readLine())!=null) {
                if ("over".equals(line))
                    break;
                out.println(line);
                String info = in.readLine();
                System.out.println("server says: "+info);
            }




            bufferR.close();
            client.close();

        } catch (IOException e) {
            out.println("wrong");
        }
    }
    public static void main(String[] args) throws Exception{
        new ClientTest();
    }
}
