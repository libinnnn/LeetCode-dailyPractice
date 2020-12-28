package com.lee.learning.leetcode.tree.二叉树中的路径最大和_124;

/**
 * @author libin
 * @date 2020-12-26 11:17
 */
public class TreeNode {

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
