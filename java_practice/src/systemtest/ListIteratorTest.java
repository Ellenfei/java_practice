package systemtest;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by ye on 2016/11/26.
 */
public class ListIteratorTest {
    public static void main (String[] args) {
        String[] books = {
                "·è¿ñjava½²Òå","·è¿ñios½²Òå",
                "java practice"  };
        List bookList = new ArrayList();
        for (int i = 0;i<books.length; i++) {
            bookList.add(books[i]);
        }

        ListIterator lit = bookList.listIterator();
        while (lit.hasNext()) {
            System.out.println(lit.next());
            lit.add("-----------!!!-----------");
        }

        System.out.println("======////\\\\\\\\======");
        while (lit.hasPrevious()) {
            System.out.println(lit.previous());
        }
    }
}
