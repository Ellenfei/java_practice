package classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Ellen on 2017/10/13.
 */
public class CompileClassLoader extends ClassLoader {

    private byte[] getBytes(String fileName) {
        File file = new File(fileName);
        long len  = file.length();
        byte[] raw = new byte[(int)len];
        try (FileInputStream fin = new FileInputStream(file)){
            int r = fin.read(raw);
            if (r!=len) {
                throw new IOException("无法读取全部文件："+r+"!="+len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return raw;
    }

    private boolean compile(String javaFile) throws IOException {
        System.out.println("正在编译："+javaFile+"....");
        Process p = Runtime.getRuntime().exec("javac "+javaFile);

        try {
            p.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int exit = p.exitValue();
        return exit==0;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz =null;
        String fileSub = name.replace(".","/");
        String javaFilename = fileSub+".java";
        String classFilename = fileSub+".class";
        File javaFile = new File(javaFilename);
        File classFile = new File(classFilename);
        if (javaFile.exists() && (!classFile.exists())
                || javaFile.lastModified()>classFile.lastModified()) {
            try {
                if (!compile(javaFilename) || (!classFile.exists())) {
                    throw new ClassNotFoundException("ClassNotFoundException:"+javaFilename);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (classFile.exists()) {
            byte[] raw = getBytes(classFilename);
            clazz = defineClass(name,raw,0,raw.length);
        }
        if (clazz==null) {
            throw new ClassNotFoundException(name);
        }
        return clazz;
    }

    public static void main(String[] args) {
        if (args.length<1) {
            System.out.print("   ......    ");
        }
    }
}
