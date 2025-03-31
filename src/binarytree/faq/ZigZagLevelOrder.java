package binarytree.faq;

import binarytree.traversal.TreeNode;

import java.util.*;

public class ZigZagLevelOrder {
    public static void main(String[] args) {

    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean ltr = true;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            LinkedList<Integer> currAnswer = new LinkedList<>();
            while (queueSize-- > 0 && !queue.isEmpty()) {
                TreeNode poppedNode = queue.poll();
                if(!ltr){
                    currAnswer.addFirst(poppedNode.data);
                }else{
                    currAnswer.addLast(poppedNode.data);
                }
                if (poppedNode.left != null) queue.offer(poppedNode.left);
                if (poppedNode.right != null) queue.offer(poppedNode.right);
            }
            ltr = !ltr;
            result.add(currAnswer);
        }
        return result;
    }
}
