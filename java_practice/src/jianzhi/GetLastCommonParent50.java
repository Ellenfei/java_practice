package jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ellen on 2018/1/22.
 */
public class GetLastCommonParent50 {
    public static void main(String[] args) {
        MyTreeNode root = new MyTreeNode(1);
        MyTreeNode n2 = new MyTreeNode(2);
        MyTreeNode n3 = new MyTreeNode(3);
        MyTreeNode n4 = new MyTreeNode(4);
        MyTreeNode n5 = new MyTreeNode(5);
        root.children.add(n2);
        n2.children.add(n3);
        n3.children.add(n4);
        n4.children.add(n5);
        System.out.print(getLastCommonParent(root, n4, n5).val);
    }
    //定义节点类
    private static class MyTreeNode {
        int val;
        List<MyTreeNode> children = new LinkedList<>();
        public MyTreeNode() {}
        public MyTreeNode(int val) {
            this.val = val;
        }
        @Override
        public String toString() {
            return val+"";
        }
    }
    //获取两个节点的最低公共祖先
    public static MyTreeNode getLastCommonParent(MyTreeNode root, MyTreeNode p1, MyTreeNode p2) {
        List<MyTreeNode> path1 = new ArrayList<>();
        List<MyTreeNode> path2 = new ArrayList<>();
        getNodePath(root, p1, path1);
        getNodePath(root, p2, path2);
        if (path1.size()==0 || path2.size()==0) {
            return null;
        }
        return getLastCommonNode(path1, path2);
    }
    //找节点的路径
    public static void getNodePath(MyTreeNode root, MyTreeNode target, List<MyTreeNode> path) {
        if (root==null) {
            return;
        }
        path.add(root);
        List<MyTreeNode> children = root.children;
        for (MyTreeNode node : children) {
            if (node==target) {
                path.add(node);
                return;
            } else {
                getNodePath(node, target, path);
            }
        }
        path.remove(path.size()-1);
    }
    //找出两个路径中的最后一个共同节点
    public static MyTreeNode getLastCommonNode(List<MyTreeNode> p1, List<MyTreeNode> p2) {
        MyTreeNode tmpNode = null;
        for (int i=0; i<p1.size() && i<p2.size(); i++) {
            if (p1.get(i) != p2.get(i)) {
                break;
            }
            tmpNode = p1.get(i);
        }
        return tmpNode;
    }
}
