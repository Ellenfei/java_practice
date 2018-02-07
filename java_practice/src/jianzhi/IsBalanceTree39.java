package jianzhi;

/**
 * Created by Ellen on 2018/1/11.
 */
public class IsBalanceTree39 {
    public static void main(String[] args) {
        MyTreeNode root = new MyTreeNode(1);
        root.left = new MyTreeNode(1);
//        root.right = new MyTreeNode(1);
        root.left.left = new MyTreeNode(1);
        System.out.print(isBalanced(root));
    }
    public static boolean isBalanced(MyTreeNode root) {
        int[] depth = new int[1];
        return isBalanced(root, depth);
    }
    //
    public static boolean isBalanced(MyTreeNode root, int[] depth) {
        if (root==null) {
            depth[0] = 0;
            return true;
        }
        //记录左右节点的深度
        int[] left = new int[1];
        int[] right = new int[1];
        if (isBalanced(root.left, left) && isBalanced(root.right, right)) {
            int diff = left[0]-right[0];
            if (diff<=1 && diff>=-1) {
                depth[0] = 1+(left[0]>right[0] ? left[0] : right[0]);
                return true;
            }
        }
        return false;
    }
}
