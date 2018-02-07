package file;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by ye on 2016/11/5.
 */
public class PathTest {
    public static void main(String[] args) {
        Path path = Paths.get(".");
        System.out.println(path.getNameCount()+"  "+path.getRoot()+"  "+
                path.getParent()+"  "+path.getFileSystem() + "  \n"+
                path.toAbsolutePath()+"\n"+path.toAbsolutePath().getRoot()+"\n"+
                path.toAbsolutePath().getNameCount()+"\n"+path.toAbsolutePath().getName(0)+"\n"+
                Paths.get("f:","publish","code").getNameCount());
    }
}
