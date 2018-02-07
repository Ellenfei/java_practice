package jianzhi;

/**
 * Created by Ellen on 18-1-26.
 * ɾ�������ظ��Ľڵ�
 */
public class DeleteDuplication57 {
    public static void main(String [] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        print(deleteDuplication(n1));
    }
    public static ListNode deleteDuplication(ListNode head) {
        if (head==null || head.next==null) {
            return head;
        }
        //��ʱͷ�ڵ�
        ListNode root = new ListNode(1);
        root.next = head;
        //��¼ǰ���ڵ�
        ListNode pre = root;
        //��ǰ�ڵ�
        ListNode curNode = head;
        while (curNode!=null && curNode.next!=null) {
            //�ظ�
            if (curNode.val==curNode.next.val) {
                //�ҵ����ظ��Ľڵ㣬ע����һ���ڵ�Ҳ�����ظ���1---2----2----2---3---3--4��
                while (curNode.next!=null && curNode.val==curNode.next.val) {
                    curNode = curNode.next;
                }
                //ָ����һ���ڵ㣬pre.nextҲ�����ظ�
                pre.next = curNode.next;
//                pre.next = curNode;
//                pre = pre.next;
            } else {
                pre.next = curNode;
                pre = pre.next;
            }
            curNode = curNode.next;
        }
        return root.next;
    }
    public static void print(ListNode head) {
        while (head!=null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}
