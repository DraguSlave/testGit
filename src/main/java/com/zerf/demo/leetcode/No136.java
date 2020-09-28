/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No136
 * Author:   Administrator
 * Date:     20/7/23/0023 14:15
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
 * @create 20/7/23/0023
 * @since 1.0.0
 */
public class No136 {
    /**
     * 任何数和0做异或运算，结果仍然是原来的数 a ^ 0 = a
     * 任何数和其自身做异或运算，结果是 0，即 a ^ a = 0。
     * 故遍历做亦或最后得到的数就是只出现一次的数
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        No136 no136 = new No136();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(no136.singleNumber(nums));
    }
}