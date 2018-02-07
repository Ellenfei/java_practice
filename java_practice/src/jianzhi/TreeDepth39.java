package jianzhi;

/**
 * Created by Ellen on 2018/1/11.
 */
public class TreeDepth39 {
    public static void main(String[] args) {
        MyTreeNode root = new MyTreeNode(1);
        root.left = new MyTreeNode(2);
        root.right = new MyTreeNode(3);
        root.left.left = new MyTreeNode(4);
        System.out.println(treeDepth(root));
    }
    public static int treeDepth(MyTreeNode root) {
        if (root==null) {
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return left>right ? (left+1) : (right+1);
    }
}
