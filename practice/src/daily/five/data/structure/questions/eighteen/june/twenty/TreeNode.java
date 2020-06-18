package daily.five.data.structure.questions.eighteen.june.twenty;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
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

    public void printTree() {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(this);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node != null) {
                System.out.println(node.data);
                q.offer(node.getLeft());
                q.offer(node.getRight());
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(5), null),new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        root.printTree();
    }
}

