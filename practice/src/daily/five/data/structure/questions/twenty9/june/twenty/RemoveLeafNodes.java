package daily.five.data.structure.questions.twenty9.june.twenty;

public class RemoveLeafNodes {
    public static void main(String[] args) {
        BinarySearchTree tree = BinarySearchTree.createDefaultTree();
        removeLeafNodes(tree.getRoot());
        tree.printTree();
    }

    public static TreeNode removeLeafNodes(TreeNode root) {
        if(root != null) {
            if(root.getLeft() == null && root.getRight()== null) {
                return null;
            }
            root.setLeft(removeLeafNodes(root.getLeft()));
            root.setRight(removeLeafNodes(root.getRight()));
        }
        return root;
    }
}
