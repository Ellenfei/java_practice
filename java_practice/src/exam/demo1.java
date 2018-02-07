package exam;


import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/4/1.
 */
class TreeNode {
    TreeNode left;
    TreeNode right;
    int value;
    TreeNode(int value) {
        this.value = value;
    }
}
public class demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] preorder = new int[n];
        int[] inorder = new int[n];
        for(int i=0; i<n; i++) {
            preorder[i] = in.nextInt();
        }
        for(int i=0; i<n; i++) {
            inorder[i] = in.nextInt();
        }

        TreeNode root = buildTree(preorder,inorder);

        if(root == null)
        {
            return ;
        }
        //树的层次遍历
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode current = null;
        queue.offer(root);//将根节点入队
        while(!queue.isEmpty())
        {
            current = queue.poll();//出队队头元素并访问
            System.out.print(current.value +" ");
            if(current.left != null)//如果当前节点的左节点不为空入队
            {
                queue.offer(current.left);
            }

            if(current.right != null)//如果当前节点的右节点不为空，把右节点入队
            {
                queue.offer(current.right);
            }
        }

    }

    //根据前序与中序重建树结构
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.value) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

}
 /*public static MyTreeNode buildTree(int[] preorder, int[] inorder) {
            return btConstruct(preorder, inorder, 0, preorder.length - 1) ;
        }

        public static MyTreeNode btConstruct(int[] preorder, int[] inorder, int l, int r) {
            int index = -1 ;
            index ++ ;
            if(l > r || r > preorder.length) {
                return null ;
            }

            MyTreeNode root = new MyTreeNode(preorder[index]) ;
            int j ;
            for(j = l; j <= r; j ++) {
                if(preorder[index] == inorder[j]) {
                    break ;
                }
            }

            if(j <= r) {
                root.left = btConstruct(preorder, inorder, l, j - 1) ;
                index -- ;
                root.right = btConstruct(preorder, inorder, j + 1, r) ;
            }

            return root ;
        }*/
