package daily.five.data.structure.questions.twenty9.june.twenty;

public class AVLTree {
    public static void main(String[] args) {
        AVLTreeNode root = new AVLTreeNode(3);

    }

    public AVLTreeNode insert(AVLTreeNode root, AVLTreeNode node) {
        if(root == null) {
            root = node;
        } else if(node.getData() < root.getData()) {
            root.setLeft(insert(root.getLeft(), node));
            if(root.getLeft().getHeight()-root.getRight().getHeight() == 2) {
                if(node.getData() < 2) {}
            }
        } else if(node.getData() > root.getData()){

        }
        root.setHeight(Math.max(root.getLeft().getHeight(), root.getRight().getHeight()) +1);
        return root;
    }

    public AVLTreeNode singleRotateForLL(AVLTreeNode u) {
        AVLTreeNode c = u.getLeft();
        u.setLeft(c.getRight());
        c.setRight(u);
        u.setHeight(Math.max(u.getLeft().getHeight(), u.getRight().getHeight()) + 1);
        c.setHeight(Math.max(c.getLeft().getHeight(), c.getRight().getHeight()));
        return c;
    }

    public AVLTreeNode singleRotateForRR(AVLTreeNode u) {
        AVLTreeNode c = u.getRight();
        u.setRight(c.getLeft());
        c.setLeft(u);
        u.setHeight(Math.max(u.getLeft().getHeight(), u.getRight().getHeight()) + 1);
        c.setHeight(Math.max(c.getLeft().getHeight(), c.getRight().getHeight()));
        return c;
    }

    public AVLTreeNode doubleRotateForLR(AVLTreeNode u) {
        u.setLeft(singleRotateForRR(u.getLeft()));
        return singleRotateForLL(u);
    }

    public AVLTreeNode doubleRotateForRL(AVLTreeNode u) {
        u.setRight(singleRotateForLL(u.getRight()));
        return singleRotateForRR(u);
    }
}
class AVLTreeNode {
    private int data;
    private AVLTreeNode left;
    private AVLTreeNode right;
    private int height;

    public AVLTreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public AVLTreeNode getLeft() {
        return left;
    }

    public void setLeft(AVLTreeNode left) {
        this.left = left;
    }

    public AVLTreeNode getRight() {
        return right;
    }

    public void setRight(AVLTreeNode right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
