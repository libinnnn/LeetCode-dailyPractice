package com.lee.learning.leetcode.tree.二叉树中序遍历_94;

import java.util.ArrayList;
import java.util.List;

/**
 * @author libin
 * @date 2020-12-24 19:48
 */



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */



class Solution {

    static List<Integer> res = new ArrayList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) { // 空节点判断，直接返回
            return res;
        }
        inorderTraversal(root.left); //遍历左子树
        res.add(root.val); //遍历根节点
        inorderTraversal(root.right); // 遍历右子树
        return res;
    }

}