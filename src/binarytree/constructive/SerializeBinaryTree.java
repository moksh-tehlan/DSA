package binarytree.constructive;

import binarytree.traversal.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(serialize(root));
    }

    public static String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder s = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                s.append("#,");
            } else {
                s.append(node.data).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return s.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        StringBuilder sb = new StringBuilder(data);
        int commaIndex = sb.indexOf(",");
        String str = sb.substring(0,commaIndex);
        TreeNode root = new TreeNode(Integer.parseInt(str));
        sb.delete(0,commaIndex+1);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            commaIndex = sb.indexOf(",");
            str = sb.substring(0,commaIndex);
            sb.delete(0,commaIndex+1);
            if(!str.equals("#")){
                node.left = new TreeNode(Integer.parseInt(str));
                queue.offer(node.left);
            }

            commaIndex = sb.indexOf(",");
            str = sb.substring(0,commaIndex);
            sb.delete(0,commaIndex+1);
            if(!str.equals("#")){
                node.right = new TreeNode(Integer.parseInt(str));
                queue.offer(node.right);
            }
        }
        return root;
    }
}
