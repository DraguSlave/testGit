/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No637
 * Author:   Administrator
 * Date:     20/9/14/0014 14:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 20/9/14/0014
 * @since 1.0.0
 */
public class No637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();

        List<TreeNode> qList = new ArrayList<>();
        List<TreeNode> temp = new ArrayList<>();
        qList.add(root);

        double sum = 0;
        for (int i = 0; i < qList.size(); i++) {
            TreeNode node = qList.get(i);
            sum = sum + node.val;

            if (node.left != null) {
                temp.add(node.left);
            }
            if (node.right != null) {
                temp.add(node.right);
            }

            if (i == qList.size() - 1) {
                list.add(sum / qList.size());
                i = -1;
                sum = 0;
                qList = temp;
                temp = new ArrayList<>();
            }
        }

        return list;
    }

    public static void main(String[] args) {
        No637 no637 = new No637();
        TreeNode root = new TreeNode(3);
        TreeNode row1l = new TreeNode(9);
        TreeNode row1r = new TreeNode(20);
        TreeNode row2l = new TreeNode(15);
        TreeNode row2r = new TreeNode(7);

        root.left = row1l;
        root.right = row1r;
        row1r.left = row2l;
        row1r.right = row2r;

        System.out.println(no637.averageOfLevels(root));
    }
}