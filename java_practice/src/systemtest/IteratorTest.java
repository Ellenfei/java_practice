package systemtest;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by ye on 2016/11/26.
 */
public class IteratorTest {
    public static void main (String [] args) {
        Collection books = new HashSet();
        books.add("java 讲义");
        books.add("java基础。。");
        books.add("hello world");
        books.add("hello");
        books.add("nihao");
        books.add("java基础!!");
        Iterator it = books.iterator();
        System.out.println(books);
        /*while (it.hasNext()) {
            String book = (String)it.next();
            System.out.println(book);
            if (book.equals("java 讲义")) {
                it.remove();
               // books.remove(book);
            }
            book = "测试";
        }
        System.out.println(books);*/

        for (Object obj : books) {
            String book = (String)obj;
            System.out.println(book);
            if (book.equals("hello world")) {
                books.remove(book);
            }
        }
        System.out.println(books);
    }
}
