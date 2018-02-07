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
    //��ת����ʹ������ָ��
    public static ListNode reverseList(ListNode head) {
        ListNode reverseHead = null; //��ת���ͷָ��
        ListNode curr = head; //��ǰָ��
        ListNode pre = null;
        ListNode next = null; //�洢��һ��ָ��
        if (head==null) {
            return reverseHead;
        }
        while (curr!=null) {
            reverseHead = curr;//��¼ͷ���
            next = curr.next; //��ǰ�ڵ���һ���ڵ�
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return reverseHead;
    }
}
