/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No189
 * Author:   Administrator
 * Date:     20/7/27/0027 14:19
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
 * @create 20/7/27/0027
 * @since 1.0.0
 */
public class No189 {
    public void rotate(int[] nums, int k) {
        if (nums != null && nums.length != 0) {
            k %= nums.length;
            int end = nums.length - 1;
            reverseArray(nums, 0, end);
            outArray(nums);
            reverseArray(nums, 0, k - 1);
            outArray(nums);
            reverseArray(nums, k, end);
            outArray(nums);
        }
    }

    private void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    private void outArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        No189 no189 = new No189();
        int[] nums = {1};
        no189.rotate(nums, 3);
        no189.outArray(nums);
    }
}