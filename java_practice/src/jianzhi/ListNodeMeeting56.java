package jianzhi;

/**
 * Created by Ellen on 18-1-26.
 * �����л�����ڽڵ�
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
        //������û�л�
        if (fast==null || fast.next==null) {
            return null;
        }
        //fast����ָ��head��slowָ����ǵ�n�����нڵ����Ŀ�����ڵ�
        fast = head;
        while (fast!=slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
    //���㻷�нڵ�ĸ���
//    public static int nodeNum(ListNode head) {
//        ListNode p1 = head;
//        ListNode p2 = head;
//
//    }
}
