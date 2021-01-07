package com.lee.learning.leetcode.tree.二叉树层序遍历_102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author libin
 * @date 2020-12-24 20:18
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // 异常情况判断
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        // 循环队列进行判断
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>(); // 用于记录每层的结构
            int concurrentLevelSize = queue.size();  // 记录层节点的个数，来对每一层进行元素的切分，归类为一组集合中
            for(int i = 1; i <= concurrentLevelSize; i++){
                TreeNode treeNode = queue.poll();
                level.add(treeNode.val);
                if(treeNode.left != null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right != null){
                    queue.add(treeNode.right);
                }
            }
            res.add(level);
        }

        return res;
    }
}
