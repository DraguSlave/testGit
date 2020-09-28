/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No239
 * Author:   Administrator
 * Date:     20/7/28/0028 9:38
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
 * @create 20/7/28/0028
 * @since 1.0.0
 */
public class No239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //1, 3, -1, -3, 5, 3, 6, 7
        //3 1 -1 -3
        // todo
        LinkedList<Integer> list = new LinkedList<>();
        int[] sum = new int[nums.length - k + 1];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                max = Math.max(nums[i], max);
                list.add(nums[i]);
            } else {
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        No239 no239 = new No239();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = no239.maxSlidingWindow(nums, 3);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}