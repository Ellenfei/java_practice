package jianzhi;

/**
 * Created by Ellen on 2018/1/31.
 * 树的序列化和反序列化
 */
public class TreeSerialize62 {
    public static void main(String[] args) {
        MyBinaryTree root = new MyBinaryTree(1);
        root.left = new MyBinaryTree(2);
        root.right = new MyBinaryTree(3);
        root.left.left = new MyBinaryTree(4);
        root.left.right = new MyBinaryTree(5);
        System.out.println(deserialize(serialize(root)).val);
    }
    //树的序列化--前序遍历
    public static String serialize (MyBinaryTree root) {
        StringBuilder sb = new StringBuilder();
        if (root==null) {
            sb.append("# ");
            return sb.toString();
        }
        sb.append(root.val+" ");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }
    //树的反序列化
    static int index = -1; //数组索引
    public static MyBinaryTree deserialize (String str) {
        index++;
        MyBinaryTree node = null;
        String[] s = str.split(" ");
        while (!s[index].equals("#")) {
            node = new MyBinaryTree(Integer.parseInt(s[index]));
            node.left = deserialize(str);
            node.right = deserialize(str);
        }
        return node;
    }
}
