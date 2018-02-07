package jianzhi;

/**
 * Created by Ellen on 2018/1/2.
 * ��������
 * 1.���Ƽ�����
 * 2.���ø��Ƴ����Ľڵ��sibling�ڵ�
 * 3.��ֳ���������
 */
class ComplexListNode<T> {
    T val;
    ComplexListNode next;
    ComplexListNode sibling;
    public ComplexListNode(T val) {
        this.val = val;
    }
}
public class CloneComplexListNode26 {
    public static void main(String[] args) {
        ComplexListNode head = new ComplexListNode(1);
        head.next = new ComplexListNode(2);
        head.next.next = new ComplexListNode(3);
        head.sibling = head.next.next;
        head.next.next.sibling = head.next;
//        cloneNodes(head);
//        connectSiblingNodes(head);
//        clone(head);
        printList(clone(head));

    }
    public static ComplexListNode clone(ComplexListNode head) {
        if (head==null) {
            return head;
        }
        cloneNodes(head);
//        System.out.print(head.next.val);
        connectSiblingNodes(head);
        return reconnectNodes(head);
    }
    //1.��������
    public static void cloneNodes(ComplexListNode head) {
        while (head!=null) {
            ComplexListNode temp = new ComplexListNode(head.val);
            temp.next = head.next;
            head.next = temp;
            head = temp.next;
        }
    }
    //2.���ýڵ��sibling
    public static void connectSiblingNodes(ComplexListNode head) {
        while (head!=null) {
//            ComplexListNode node = head.next;
            if (head.sibling!=null) {
                head.next.sibling = head.sibling.next;
            }
            head = head.next.next;
        }
    }
    //3.�������
    public static ComplexListNode reconnectNodes(ComplexListNode head) {
        if (head==null) {
            return null;
        }
        //����������½ڵ�
        ComplexListNode newHead = head.next;
        //���ڼ�¼��ǰ����ĸ��ƽڵ�
        ComplexListNode pointer = newHead;
//        while (head!=null && pointer!=null) {
//            head.next = pointer.next;
//            head = head.next;
//            if (head!=null) {
//                pointer.next = head.next;
//                pointer = pointer.next;
//            }
//        }
        head.next = newHead.next;
        //ָ��ڶ����ڵ�
        head = head.next;
        while (head!=null) {
            //System.out.println(pointer.val);
            pointer.next = head.next;
            pointer = pointer.next;
            if (pointer.next!=null) {
                head.next = pointer.next;
            }
            head = pointer.next;
        }
        return newHead;
    }
    //��ӡ����
    public static void printList(ComplexListNode head) {
        while (head!=null) {
            System.out.print(head.val+"-->");
            head = head.next;
        }
        System.out.print("null");
    }
}
