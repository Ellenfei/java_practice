package systemtest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * Created by ye on 2016/11/24.
 */
public class SystemTest {
    public static void main(String[] args) throws IOException {
        /*Map<String,String> env = System.getenv();
        for (String name : env.keySet()) {
            System.out.println(name+"--->"+env.get(name));
        }
        Properties props = System.getProperties();
        props.store(new FileOutputStream("props.txt"),"System Properties");*/
        Runtime rt = Runtime.getRuntime();
        System.out.println("处理器数量："+rt.availableProcessors());
        System.out.println(rt.freeMemory());
    }
}
