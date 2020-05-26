package daily.five.data.structure.questions.twenty6.may.twenty;

import daily.five.data.structure.questions.TreeNode;

public class BinaryTreeSize {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getDefaultTree();
        int size = findSize(root);
        System.out.println(size);
    }

    private static int findSize(TreeNode root) {
        if(root.getLeft() == null && root.getRight() == null) {
            return 1;
        }
        return 1+findSize(root.getLeft())+findSize(root.getRight());
    }
}
