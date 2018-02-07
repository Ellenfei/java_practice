package demo1_3;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ye on 2017/1/17.
 */
public class treePaths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(15);
        root.left.right  = new TreeNode(15);

        System.out.print(binaryTreePaths(root));
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        /*List<String> paths = new LinkedList<String>();
        if (root == null)
            return paths;

        if (root.left == null && root.right == null) {
            paths.add(root.val + "");
            return paths;
        }

        for (String path : binaryTreePaths(root.left)) {
            paths.add(root.val+"->"+path);
        }

        for (String path : binaryTreePaths(root.right)) {
            paths.add(root.val+"->"+path);
        }

        return paths;*/


        List<String> result = new LinkedList<String>();
        if (root != null) {
            searchBT(root,"",result);
        }
      return result;
    }

    public static void searchBT(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(path+root.val);
        }
        if (root.left != null) {
            searchBT(root.left, path + root.val + "->", result);
        }
        if (root.right != null) {
            searchBT(root.right,path+root.val+"->",result);
        }
    }
}
