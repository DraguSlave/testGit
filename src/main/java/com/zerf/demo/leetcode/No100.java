/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No100
 * Author:   Administrator
 * Date:     20/7/21/0021 10:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.leetcode;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 20/7/21/0021
 * @since 1.0.0
 */
public class No100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode treeNodeP1 = new TreeNode(1);
        TreeNode treeNodeP2 = new TreeNode(2);
        TreeNode treeNodeP3 = new TreeNode(3);
        treeNodeP1.left = treeNodeP2;
        treeNodeP1.right = treeNodeP3;

        TreeNode treeNodeQ1 = new TreeNode(1);
        TreeNode treeNodeQ2 = new TreeNode(3);
        TreeNode treeNodeQ3 = new TreeNode(2);
        treeNodeQ1.left = treeNodeQ2;
        treeNodeQ1.right = treeNodeQ3;

        No100 no100 = new No100();
        System.out.println(no100.isSameTree(treeNodeP1, treeNodeQ1));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}