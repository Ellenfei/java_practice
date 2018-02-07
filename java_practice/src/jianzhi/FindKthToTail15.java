package jianzhi;

/**
 * Created by Ellen on 2017/12/22.
 */
public class FindKthToTail15 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        //head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        System.out.print(findKthToTail(head, 2).val);
    }
    //使用两个指针找到第n-k+1，p1与p2相差k-1个节点
    public static ListNode findKthToTail(ListNode head, int k) {
        if (head==null) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1!=null && k>1) {
            p1 = p1.next;
            k--;
        }
        if (k!=2) {
            throw new RuntimeException("k is too big");
        }
        System.out.println(p1.val);
        while (p1.next!=null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
