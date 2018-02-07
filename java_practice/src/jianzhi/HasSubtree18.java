package jianzhi;

/**
 * Created by Ellen on 2017/12/25.
 */
public class HasSubtree18 {
    public static void main(String[] args) {
        MyTreeNode root1 = new MyTreeNode(1);
        root1.left = new MyTreeNode(2);
        root1.right = new MyTreeNode(3);
        root1.left.left = new MyTreeNode(4);
        root1.left.right = new MyTreeNode(5);
        MyTreeNode root2 = new MyTreeNode(2);
        root2.left = new MyTreeNode(4);
        root1.right = new MyTreeNode(5);
        System.out.print(hasSubtree(root1.right, root2));
    }
    public static boolean hasSubtree(MyTreeNode root1, MyTreeNode root2) {
        if (root1==root2) {
            return true;
        }
        if (root2==null) {
            return true;
        }
        if (root1==null) {
            return false;
        }
        boolean result = false;
        if (root1.val==root2.val) {
            result = match(root1, root2);
        }
        if (result) {
            return true;
        }
        return hasSubtree(root1.left, root2) || hasSubtree(root1.left, root2);
    }

    public static boolean match(MyTreeNode root1, MyTreeNode root2) {
        if (root1==root2) {
            return true;
        }
        if (root2==null) {
            return true;
        }
        if (root1==null) {
            return false;
        }
        return match(root1.left, root2.left) && match(root1.right, root2.right);
    }

}
