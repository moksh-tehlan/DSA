package binarytree.faq;

import binarytree.traversal.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideViewBT {
    public static void main(String[] args) {

    }

    private static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            while (queueSize-- > 0 && !queue.isEmpty()) {
                TreeNode poppedNode = queue.poll();
                if(queueSize == 0)ans.add(poppedNode.data);
                if(poppedNode.left != null)queue.offer(poppedNode.left);
                if(poppedNode.right != null)queue.offer(poppedNode.right);
            }
        }
        return ans;
    }
}
