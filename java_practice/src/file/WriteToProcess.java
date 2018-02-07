package file;

import java.io.*;
import java.util.Scanner;

/**
 * Created by ye on 2016/11/2.
 */

public class WriteToProcess {
    public static void main(String[] args) throws IOException {
        Process p = Runtime.getRuntime().exec("java ReadStandard");
        PrintStream ps = new PrintStream(p.getOutputStream());
        ps.println("hello\r\n");
        ps.println(new WriteToProcess());

        BufferedReader br = new BufferedReader(new FileReader("E:\\Ellen_study\\java_practice\\src\\file\\" +
                "out1.txt"));
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}


class ReadStandard {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        PrintStream ps = new PrintStream(new FileOutputStream("E:\\Ellen_study\\java_practice\\src\\file\\" +
                "out1.txt"));
        in.useDelimiter("\n");
        while (in.hasNext()) {
            ps.println(in.next());
        }

    }
}

