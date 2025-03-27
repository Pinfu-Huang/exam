package com.pinfall.exam;

import java.util.ArrayList;
import java.util.List;

// 定义二叉树节点类
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeInorderTraversal {
    // 递归方法实现遍历
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderRecursive(root, result);
        return result;
    }

    private void inorderRecursive(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorderRecursive(node.left, result);
        result.add(node.val);
        inorderRecursive(node.right, result);
    }


    public static void main(String[] args) {
        // 构建一个简单的二叉树
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();
        List<Integer> recursiveResult = solution.inorderTraversalRecursive(root);
        System.out.println("遍历结果: " + recursiveResult);
    }
}
