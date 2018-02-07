package file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ye on 2016/11/1.
 */
public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        String line = null;
        while ((line = br.readLine()) != null) {
            if (line.equals("exit") ) {
                System.exit(1);
            }
            System.out.print(line);
        }

        reader.close();
        br.close();
    }
}
