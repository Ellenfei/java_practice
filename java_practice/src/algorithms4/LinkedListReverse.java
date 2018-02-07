package algorithms4;

/**
 * Created by Ellen on 2017/7/7.
 */
class Node<T> {
    T item;
    Node next;
    public Node(T item) {
        this.item = item;
    }
}
public class LinkedListReverse {

    public static void main(String[] args) {
        Node first = new Node("to");
        Node second = new Node("be");
        Node third = new Node("or");
        first.next = second;
        second.next = third;
        System.out.println(reverse(first).item);
    }
    public static Node reverse(Node first) {
        if (first==null) return null;
        if (first.next==null) return first;
        Node second = first.next;
        Node result = reverse(second);
        second.next = first;
        first.next = null;
        return result;
    }
}
