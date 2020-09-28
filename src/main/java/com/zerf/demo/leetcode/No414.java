/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No414
 * Author:   Administrator
 * Date:     20/8/5/0005 15:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.leetcode;

import java.util.LinkedList;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 20/8/5/0005
 * @since 1.0.0
 */
public class No414 {
    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        LinkedList<Integer> list = new LinkedList<>();
        Integer first = null;
        Integer second = null;
        Integer third = null;
        int count = 0;
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if (flag) {
                if (first == null || nums[i] > first) {
                    third = second;
                    second = first;
                    first = nums[i];
                } else if (second == null || nums[i] > second) {
                    third = second;
                    second = nums[i];
                } else if (third == null || nums[i] > third) {
                    third = nums[i];
                }
                if (third != null) {
                    flag = false;
                }
            } else {
                if (nums[i] > first) {
                    third = second;
                    second = first;
                    first = nums[i];
                }
            }
        }
        if (flag) {
            return first;
        }
        return third;

    }

    public static void main(String[] args) {
        No414 no414 = new No414();
        int[] nums = {2, 2, 3, 1};
        System.out.println(no414.thirdMax(nums));
    }
}