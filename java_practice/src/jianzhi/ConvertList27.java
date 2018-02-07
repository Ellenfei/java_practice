package jianzhi;

/**
 * Created by Ellen on 2018/1/3.
 * 把搜索二叉树转换为双向链表
 */
public class ConvertList27 {
    public static void main(String[] args) {
        MyTreeNode root = new MyTreeNode(10);
        root.left = new MyTreeNode(6);
        root.right = new MyTreeNode(14);
        root.left.left = new MyTreeNode(4);
        MyTreeNode head = convert(root);
        while (head!=null) {
            System.out.print(head.val+" ");
            head = head.right;
        }
    }

    public static MyTreeNode convert(MyTreeNode root) {
        if (root==null) {
            return null;
        }
        MyTreeNode[] lastNode = new MyTreeNode[1];
        convertNode(root, lastNode);
        System.out.print(lastNode[0].val+" ");
        MyTreeNode headNode = lastNode[0];
        //返回头结点
//        MyTreeNode headNode = convertNode(root, lastNode);
        while (headNode!=null && headNode.left!=null) {
            headNode = headNode.left;
        }
        return headNode;
    }
    //中序遍历
    public static void convertNode(MyTreeNode root, MyTreeNode[] lastNode) {
        MyTreeNode currNode = root;
        if (currNode!=null) {
            if (currNode.left!=null) {
                convertNode(currNode.left, lastNode);
            }
            currNode.left = lastNode[0];
            //lastNode = currNode;
            if (lastNode[0]!=null) {
                lastNode[0].right = currNode;
            }
            lastNode[0] = currNode;
            if (currNode.right!=null) {
                convertNode(currNode.right, lastNode);
            }
        }
        //return lastNode;
    }
}
