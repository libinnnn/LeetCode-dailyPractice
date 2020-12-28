package com.lee.learning.leetcode.tree.路径总和III_437;

/**
 * @author libin
 * @date 2020-12-26 11:15
 */
public class Solution { private static int count = 0;

    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        int result = countPath(root,sum); // 每个节点都需要递归去计算，因为路径并不是从头开始，每个节点到子节点的路径都可以
        int a = pathSum(root.left,sum);
        int b = pathSum(root.right,sum);
        return result+a+b;

    }

    public int countPath(TreeNode root,int sum){
        if(root == null){
            return 0; // 当节点为空的时候，这时候代表匹配失败
        }
        sum = sum - root.val;
        int result = sum == 0 ? 1:0; // 根据sum的值来判断当前是否匹配路径完成，如果值不相等，返回0代表匹配失败
        return result + countPath(root.left,sum) + countPath(root.right,sum); // 返回该节点下左右子树的匹配成功的总和
    }



}
