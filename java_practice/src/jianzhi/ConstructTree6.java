package jianzhi;

/**
 * Created by Ellen on 2017/12/12.
 * 1.确定根节点，左子树，右子树
 * 2.进入左子树递归遍历
 * 3.进入右子树递归遍历
 * 4.打印根节点
 */

class MyTreeNode {
    int val;
    MyTreeNode left = null;
    MyTreeNode right = null;
    public MyTreeNode(int val) {
        this.val = val;
    }
}
public class ConstructTree6 {
    public static MyTreeNode construct(int[] preorder, int[] inorder) {
        if (preorder.length!=inorder.length || preorder.length<1 ) {
            return null;
        }
        return construct(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public static MyTreeNode construct(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps>pe || is>ie) {
            return null;
        }
        //在中序inorder寻找根节点----preorder[ps]
        int index = is;
        while (index<=ie && preorder[ps]!=inorder[index]) {
            index++;
        }
        //没有找到,不存在
        if (index>ie) {
            return null;
        }
        //找到了inorder中的根节点
        MyTreeNode node = new MyTreeNode(preorder[ps]);
        node.left = construct(preorder, ps+1, ps+index-is, inorder, is, index-1);
        node.right = construct(preorder, ps+index-is+1, pe, inorder, index+1, ie);
        return node;
    }
}
