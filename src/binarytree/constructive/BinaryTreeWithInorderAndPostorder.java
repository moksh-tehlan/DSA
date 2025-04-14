package binarytree.constructive;

import binarytree.traversal.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeWithInorderAndPostorder {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int pStart, int pEnd, Map<Integer, Integer> map) {
        if (inStart > inEnd || pStart > pEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[pEnd]);
        int inRoot = map.get(root.data);
        int numsLeftInInorder = inRoot - inStart;

        root.left = buildTree(inorder, inStart, inRoot - 1, postorder, pStart, pStart + numsLeftInInorder-1, map);
        root.right = buildTree(inorder, inRoot + 1, inEnd, postorder, pStart + numsLeftInInorder, pEnd - 1, map);
        return root;
    }
}
