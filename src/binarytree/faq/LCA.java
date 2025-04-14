package binarytree.faq;

import binarytree.traversal.TreeNode;

public class LCA {
    public static void main(String[] args) {

    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) return root;
        if (root.left == null && root.right == null) {
            return null;
        }

        TreeNode left = root.left == null ? null : lowestCommonAncestor(root.left, p, q);
        TreeNode right = root.right == null ? null : lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
        //your code goes here
    }
}
