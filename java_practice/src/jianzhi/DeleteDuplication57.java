package jianzhi;

/**
 * Created by Ellen on 18-1-26.
 * 删除所有重复的节点
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
        //临时头节点
        ListNode root = new ListNode(1);
        root.next = head;
        //记录前驱节点
        ListNode pre = root;
        //当前节点
        ListNode curNode = head;
        while (curNode!=null && curNode.next!=null) {
            //重复
            if (curNode.val==curNode.next.val) {
                //找到不重复的节点，注意下一个节点也可能重复（1---2----2----2---3---3--4）
                while (curNode.next!=null && curNode.val==curNode.next.val) {
                    curNode = curNode.next;
                }
                //指向下一个节点，pre.next也可能重复
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
