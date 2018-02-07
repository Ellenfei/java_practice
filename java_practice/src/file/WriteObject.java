package file;

import java.io.*;

/**
 * Created by ye on 2016/11/3.
 */

public class WriteObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\Ellen_study\\java_practice" +
                "\\src\\file\\object.txt"));
        Person person = new Person("12",18);
        oos.writeObject(person);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\Ellen_study\\java_practice" +
                "\\src\\file\\object.txt"));
        Person p = (Person)ois.readObject();
        System.out.println(p.getName()+"  "+p.getAge());

    }
}


class Person implements Serializable{
    private String name;
    private int age;

    public Person(String name, int age) {
        System.out.println("有参构造器");
        this.name = name;
        this.age = age;
    }

    public String getName(){ return name;}
    public int getAge() { return age; }
}

