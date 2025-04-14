package binarytree.constructive;

import binarytree.traversal.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeWithInorderAndPreorder {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = buildTreeHelper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }

    public TreeNode buildTreeHelper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, Map<Integer, Integer> imap) {
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pStart]);
        int inRoot = imap.get(root.data);

        int numLeft = inRoot - iStart;

        root.left = buildTreeHelper(preorder, pStart + 1, pStart + numLeft, inorder, iStart, inRoot - 1, imap);
        root.right = buildTreeHelper(preorder,pStart+numLeft+1,pEnd,inorder,inRoot+1,iEnd,imap);

        return root;
    }
}
