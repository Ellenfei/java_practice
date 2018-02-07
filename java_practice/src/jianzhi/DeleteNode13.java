package jianzhi;

/**
 * Created by Ellen on 2017/12/20.
 * 删除链表中的某一个节点
 * 注意：因为JAVA引用传递的原因，如果删除的结点是头结点，如果不采用返回值的方式，那么头结点永远删除不了
 * 输入的待删除结点必须是待链表中的结点，否则会引起错误，这个条件由用户进行保证
 * 时间效率：O(1)----不能采用顺序查找O(n)
 */
class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
public class DeleteNode13 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode del = head;
        //del.next = new ListNode(4);
        printList(deleteNode(head, del));
    }

    //打印链表
    public static void printList(ListNode head) {
        while (head!=null) {
            System.out.print(head.val+"---->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static ListNode deleteNode(ListNode head, ListNode toBeDeleted) {
        if (head==null || toBeDeleted==null) {
            return head;
        }
        //删除头结点
        if (head==toBeDeleted) {
            return head.next;
        }
        //删除尾节点--顺序查找
        if (toBeDeleted.next!=null) {
            ListNode nextNode = toBeDeleted.next;
            toBeDeleted.val = nextNode.val;
            toBeDeleted.next = nextNode.next;
            //return head;
        } else {
            //删除尾节点
            ListNode temp = head;
            while (temp.next!=toBeDeleted) {
                temp = temp.next;
            }
            temp.next = null;
        }
        return head;
    }
}
