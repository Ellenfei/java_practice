package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by ye on 2016/11/1.
 */
public class RedirectOut {
    public static void main(String[] args) throws FileNotFoundException {
        /*PrintStream ps = new PrintStream("E:\\Ellen_study\\java_practice\\src\\file\\" +
                "out.txt");
        System.setOut(ps);
        System.out.print("ÆÕÍ¨×Ö·û´®\r\n");
        System.out.println(new RedirectOut());*/

        FileInputStream fis = new FileInputStream("E:\\Ellen_study\\java_practice\\src\\file\\"  +
                "RedirectOut.java");
        System.setIn(fis);
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        while (sc.hasNext()) {
            System.out.println(sc.next());
        }
    }
}
