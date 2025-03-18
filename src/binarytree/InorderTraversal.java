package binarytree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<Integer> ans = inorder(root);
        for(Integer i : ans){
            System.out.print(i+" ");
        }
    }

    private static List<Integer> inorder(TreeNode root) {
        return inorderHelper(root,new ArrayList<>());
    }

    private static List<Integer> inorderHelper(TreeNode root,List<Integer> ans) {
        if(root == null){
            return ans;
        }
        inorderHelper(root.left,ans);
        ans.add(root.data);
        inorderHelper(root.right,ans);
        return ans;
    }
}
