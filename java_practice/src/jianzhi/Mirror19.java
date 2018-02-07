package jianzhi;

/**
 * Created by Ellen on 2017/12/26.
 */
public class Mirror19 {
    public static void main(String[] args) {
        MyTreeNode root = new MyTreeNode(1);
        root.left = new MyTreeNode(2);
        root.right = new MyTreeNode(3);
        root.left.left = new MyTreeNode(4);
        //mirror(root);
        printTree(mirror(root));
    }
    public static MyTreeNode mirror(MyTreeNode root) {
        if (root==null) {
            return null;
        }
        //前序遍历
        MyTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirror(root.left);
        mirror(root.right);
        return root;
    }
    //打印二叉树
    public static void printTree(MyTreeNode root) {
        if (root!=null) {
            System.out.println(root.val);
            printTree(root.left);
            printTree(root.right);
        }
    }
}
