package binarytree.faq;

import binarytree.traversal.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BoundaryPrint {
    public static void main(String[] args) {

    }

    public List<Integer> boundary(TreeNode root) {
        if(root.left == null && root.right == null){
            List<Integer> answer = new ArrayList<>();
            answer.add(root.data);
            return answer;
        }
        List<Integer> answer = new ArrayList<>();
        answer.add(root.data);
        leftNodesFinder(root.left, answer);
        List<Integer> leafNodes = new ArrayList<>();
        leafNodeFinder(root, leafNodes);
        LinkedList<Integer> rightNodes = new LinkedList<>();
        rightNodesFinder(root.right,rightNodes);
        answer.addAll(leafNodes);
        answer.addAll(rightNodes);
        return answer;
    }

    public void rightNodesFinder(TreeNode node, LinkedList<Integer> rightNodes) {
        if (node == null) return;
        if (node.left == null && node.right == null) return;
        rightNodes.addFirst(node.data);
        if (node.right != null) rightNodesFinder(node.right, rightNodes);
        else rightNodesFinder(node.left, rightNodes);
    }

    public void leafNodeFinder(TreeNode node, List<Integer> leafs) {
        if (node == null) return;
        leafNodeFinder(node.left, leafs);
        if (node.left == null && node.right == null) {
            leafs.add(node.data);
        }
        leafNodeFinder(node.right, leafs);
    }

    public void leftNodesFinder(TreeNode node, List<Integer> left) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) return;
        left.add(node.data);
        if (node.left != null) leftNodesFinder(node.left, left);
        else leftNodesFinder(node.right, left);
    }
}
