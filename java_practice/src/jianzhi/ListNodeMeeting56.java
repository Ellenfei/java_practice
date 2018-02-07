package jianzhi;

/**
 * Created by Ellen on 18-1-26.
 * 链表中环的入口节点
 */
public class ListNodeMeeting56 {
    public static void main(String [] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n5;
        System.out.println(meetingNode(n1).val);
    }
    public static ListNode meetingNode(ListNode head) {
        if (head==null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow) {
                break;
            }
        }
        //链表中没有环
        if (fast==null || fast.next==null) {
            return null;
        }
        //fast重新指向head，slow指向的是第n（环中节点的数目）个节点
        fast = head;
        while (fast!=slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
    //计算环中节点的个数
//    public static int nodeNum(ListNode head) {
//        ListNode p1 = head;
//        ListNode p2 = head;
//
//    }
}
