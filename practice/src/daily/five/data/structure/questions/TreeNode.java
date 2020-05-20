package daily.five.data.structure.questions;

public class TreeNode {
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
    
    public static TreeNode getDefaultTree() {
        return new TreeNode(
                1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)),
                new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null))
        );

    }
}
