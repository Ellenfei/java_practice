package jianzhi;

/**
 * Created by Ellen on 2017/12/20.
 * ɾ�������е�ĳһ���ڵ�
 * ע�⣺��ΪJAVA���ô��ݵ�ԭ�����ɾ���Ľ����ͷ��㣬��������÷���ֵ�ķ�ʽ����ôͷ�����Զɾ������
 * ����Ĵ�ɾ���������Ǵ������еĽ�㣬����������������������û����б�֤
 * ʱ��Ч�ʣ�O(1)----���ܲ���˳�����O(n)
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

    //��ӡ����
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
        //ɾ��ͷ���
        if (head==toBeDeleted) {
            return head.next;
        }
        //ɾ��β�ڵ�--˳�����
        if (toBeDeleted.next!=null) {
            ListNode nextNode = toBeDeleted.next;
            toBeDeleted.val = nextNode.val;
            toBeDeleted.next = nextNode.next;
            //return head;
        } else {
            //ɾ��β�ڵ�
            ListNode temp = head;
            while (temp.next!=toBeDeleted) {
                temp = temp.next;
            }
            temp.next = null;
        }
        return head;
    }
}
