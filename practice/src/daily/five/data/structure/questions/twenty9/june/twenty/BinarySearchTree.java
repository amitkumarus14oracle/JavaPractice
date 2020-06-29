package daily.five.data.structure.questions.twenty9.june.twenty;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void insert(TreeNode node) {
        TreeNode temp = root;
        TreeNode prev = null;
        boolean isLeft = true;
        while(temp != null) {
            prev = temp;
            if(temp.getData() > node.getData()) {
                temp = temp.getLeft();
                isLeft = true;
            } else {
                temp = temp.getRight();
                isLeft = false;
            }
        }
        if(prev == null) {
            root = node;
        } else if(isLeft){
            prev.setLeft(node);
        } else {
            prev.setRight(node);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode node = new TreeNode(4);
        tree.insert(node);
        tree.printTree();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        tree.insert(node1);
        tree.insert(node2);
        tree.insert(node3);
        tree.insert(node4);
        tree.printTree();
    }

    public static BinarySearchTree createDefaultTree() {
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode node = new TreeNode(4);
        tree.insert(node);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        tree.insert(node1);
        tree.insert(node2);
        tree.insert(node3);
        tree.insert(node4);
        return tree;
    }

    public void printTree() {
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.getLeft() != null) {
                q.offer(node.getLeft());
            }
            if(node.getRight() != null) {
                q.offer(node.getRight());
            }
            System.out.println(node.getData());
        }
    }
}
class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;

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

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}


