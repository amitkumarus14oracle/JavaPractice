package daily.five.data.structure.questions.seventeen.may.twenty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeImpl {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)),
                new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null))
        );

        printLevelOrder(root);
    }

    public static void printLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<TreeNode> l = new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            l.add(node);
            if(node.getLeft() != null) {
                q.offer(node.getLeft());
            }
            if(node.getRight() != null) {
                q.offer(node.getRight());
            }
        }
        System.out.println(l);
    }
}
class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public String toString() {
        return String.valueOf(data);
    }
}
