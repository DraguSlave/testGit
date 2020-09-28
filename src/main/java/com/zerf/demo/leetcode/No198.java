/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No198
 * Author:   Administrator
 * Date:     20/7/28/0028 9:08
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
 * @create 20/7/28/0028
 * @since 1.0.0
 */
public class No198 {
    public int rob(int[] nums) {
        //转态方程dp[n] = max(dp[n-1], dp[n-2] + num)
        int cur = 0;
        int pre = 0;
        int temp;
        for (int num : nums) {
            temp = cur;
            cur = Math.max(cur, pre + num);
            pre = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        No198 no198 = new No198();
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(no198.rob(nums));
    }
}