package practice;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ye on 2016/10/23.
 */

class TimeServerHandler implements Runnable{
    private Socket socket;
    public TimeServerHandler(Socket socket){
    this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(),true);
            String currentTime = null;
            String body = null;
            while (true){
                body = in.readLine();
                if (body == null)
                    break;
                System.out.println("The Time receive order:"+body);
                currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new java.util.Date(
                        System.currentTimeMillis()).toString() : "BAD ORDER";
                out.println(currentTime);
            }

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class TimeServer {
    public static void main(String args[]){
        int port = 8080;
        if (args != null && args.length>0){
            port = Integer.valueOf(args[0]);
        }

        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("The Time starts port is:" + port);
            Socket socket = null;
            while (true){
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }

        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null){
                try {
                    server = null;
                    server.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
