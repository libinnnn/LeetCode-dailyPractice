package com.lee.learning.leetcode.tree.二叉树后序遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * @author libin
 * @date 2020-12-26 20:13
 */
public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }


}