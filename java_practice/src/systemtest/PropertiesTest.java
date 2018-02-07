package systemtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by ye on 2016/11/26.
 */
public class PropertiesTest {
    public static void main (String[] args) throws IOException {
        Properties props = new Properties();
        props.setProperty("username","yeeku");
        props.setProperty("password", "123456");
        props.store(new FileOutputStream("a.properties"), "comment line");
        Properties props2 = new Properties();
        props2.setProperty("gender","male");
        props2.load(new FileInputStream("a.properties"));
        System.out.println(props2);
    }
}
