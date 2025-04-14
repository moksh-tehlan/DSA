package binarytree.faq;

import binarytree.traversal.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBinaryTree {
    public static void main(String[] args) {

    }

    private static int widthOfBinaryTree(TreeNode root) {
        //your code goes here
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(0, root));
        int minOfLevel = 0;
        int maxLength = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            int startIndex = queue.peek().index, endIndex = 0;
            while (queueSize-- > 0 && !queue.isEmpty()) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int index = pair.index;
                if(queueSize == 0){
                    endIndex = index;
                }

                if (node.left != null) {
                    int leftIndex = ((2 * index) + 1) - minOfLevel;
                    queue.offer(new Pair(leftIndex, node.left));
                }
                if (node.right != null) {
                    int rightIndex = ((2 * index) + 2) - minOfLevel;
                    queue.offer(new Pair(rightIndex, node.right));
                }
            }
            maxLength = Math.max(maxLength,endIndex-startIndex+1);
            if (queue.peek() != null) {
                minOfLevel = queue.peek().index;
            }
        }
        return maxLength;
    }

    private static class Pair {
        int index;
        TreeNode node;

        Pair(int index, TreeNode node) {
            this.index = index;
            this.node = node;
        }
    }
}
