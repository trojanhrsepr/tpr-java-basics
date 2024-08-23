package binarytree;

import java.util.LinkedList;
import java.util.List;

public class DFS{}

// Binary tree preorder: Pre-order traversal is to 
// visit the root first. Then traverse the left subtree. Finally, 
// traverse the right subtree.
/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    // DFS while
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if(root == null) {
            return output;
        }
        
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if(node.right != null) {
                stack.add(node.right);
            }
            if(node.left!=null) {
                stack.add(node.left);
            }
        }
        return output;
    }

    // DFS Recursion
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        else {
            int lh = maxDepth(root.left);
            int rh = maxDepth(root.right);
            return java.lang.Math.max(lh, rh) + 1;
        }
    }
}