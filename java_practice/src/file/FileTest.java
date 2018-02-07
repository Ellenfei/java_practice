package file;

import java.io.File;
import java.io.IOException;

/**
 * Created by ye on 2016/10/31.
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File(".");
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getAbsoluteFile().getParent());
        //File tmpFile = File.createTempFile("bkk", ".java", file);
        //System.out.println(tmpFile.getAbsolutePath());
        //tmpFile.deleteOnExit();
       // File newFile = new File(System.currentTimeMillis()+"");
       // System.out.println(newFile.getName());
        //newFile.createNewFile();
       // System.out.println(newFile.mkdir());
        String[] fileList = file.list();
        for (String fileName : fileList) {
            System.out.println(fileName);
        }
        File[] roots = File.listRoots();
        for (File root : roots) {
            System.out.println(root);
        }

        /*String[] nameList = file.list((dir,name)->name.endsWith(".java")
            || new File(name).isDirectory());*/
    }
}
