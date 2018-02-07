package jianzhi;

import java.util.List;

/**
 * Created by Ellen on 2017/12/25.
 */
public class MergeLinkedList {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        System.out.println(merge(head1, head2).next.next.next.val);
    }
    public static ListNode merge(ListNode head1, ListNode head2) {
        if (head1==null) {
            return head2;
        }
        if (head2==null) {
            return head1;
        }
        ListNode root = new ListNode(9);
//        if (head1.val<head2.val) {
//            root.next = head1;
//        } else {
//            root.next = head2;
//        }
        ListNode pointer = root;
        while (head1!=null && head2!=null) {
            if (head1.val<head2.val) {
                pointer.next = head1;
                head1 = head1.next;
            } else {
                pointer.next = head2;
                head2 = head2.next;
            }
            pointer = pointer.next;
        }
        if (head1!=null) {
            pointer.next = head1;
        }
        if (head2!=null) {
            pointer.next = head2;
        }
        return root.next;
    }
}
