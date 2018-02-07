package IOpractice;

import java.io.*;

/**
 * Created by Ellen on 2017/9/25.
 */
public class printWrite {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter pw = new PrintWriter(new FileWriter("out.txt"),true);
        String line = null;
        while ((line=buf.readLine())!=null) {
            if ("over".equals(line)) break;
            pw.println(line.toUpperCase());
        }
        pw.close();
        buf.close();
    }
}
