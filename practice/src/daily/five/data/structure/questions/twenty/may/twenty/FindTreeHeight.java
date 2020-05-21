package daily.five.data.structure.questions.twenty.may.twenty;

import daily.five.data.structure.questions.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindTreeHeight {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getDefaultTree();
        TreeNode root1 = new TreeNode(1, null, null);
        TreeNode root2 = new TreeNode(1,
                            new TreeNode(2, new TreeNode(3,
                                new TreeNode(4,
                                    new TreeNode(5, null, null), null), null), null),
                    null);
        int height = findHeight(root);
        System.out.println("height of the tree is :"+height);
        System.out.println("height of the tree is :"+findHeight(root1));
        System.out.println("height of the tree is :"+findHeight(root2));
    }

    private static int findHeight(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
            return 0;
        q.offer(root);
        q.offer(null);
        int h = 1;
        while(!q.isEmpty()) {
            TreeNode elem = q.poll();
            if(elem != null) {
                if(elem.getLeft() != null)
                    q.offer(elem.getLeft());
                if(elem.getRight() != null)
                    q.offer(elem.getRight());
            } else {
                if(q.size() != 0){
                    q.offer(null);
                    h++;
                }
            }
        }
        return h;
    }
}
