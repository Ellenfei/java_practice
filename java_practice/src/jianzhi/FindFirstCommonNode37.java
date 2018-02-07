package jianzhi;

/**
 * Created by Ellen on 2018/1/10.
 */
public class FindFirstCommonNode37 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        ListNode n7 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n5.next = n6;
        n6.next = n7;
        System.out.println(findFirstCommonNode(n1, n5));
    }
    public static ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        int len1 = getLength(head1);
        int len2 = getLength(head2);
        int diff = len1-len2;
        ListNode longestHead = head1;
        ListNode shortestHead = head2;
        if (diff<0) {
            longestHead = head2;
            shortestHead = head1;
            diff = len2-len1;
        }
        while (diff>0) {
            longestHead = longestHead.next;
            diff--;
        }
        while (longestHead!=null && shortestHead!=null && longestHead.val!=shortestHead.val) {
            longestHead = longestHead.next;
            shortestHead = shortestHead.next;
        }
        return longestHead;
    }
    public static int getLength(ListNode head) {
        if (head==null) {
            return 0;
        }
        int len = 0;
        while (head!=null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
