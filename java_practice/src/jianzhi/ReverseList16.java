package jianzhi;

/**
 * Created by Ellen on 2017/12/23.
 */
public class ReverseList16 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        System.out.print(reverseList(head).val);
    }
    //翻转链表，使用三个指针
    public static ListNode reverseList(ListNode head) {
        ListNode reverseHead = null; //翻转后的头指针
        ListNode curr = head; //当前指针
        ListNode pre = null;
        ListNode next = null; //存储下一个指针
        if (head==null) {
            return reverseHead;
        }
        while (curr!=null) {
            reverseHead = curr;//记录头结点
            next = curr.next; //当前节点下一个节点
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return reverseHead;
    }
}
