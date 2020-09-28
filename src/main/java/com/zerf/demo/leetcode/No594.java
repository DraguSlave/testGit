/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No594
 * Author:   Administrator
 * Date:     20/9/17/0017 9:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.leetcode;

import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 20/9/17/0017
 * @since 1.0.0
 */
public class No594 {
    public int findLHS(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int n = map.getOrDefault(num, 0) + 1;
            map.put(num, n);
            if (map.containsKey(num - 1) || map.containsKey(num + 1)) {
                int length = Math.max(map.getOrDefault(num - 1, 0), map.getOrDefault(num + 1, 0));
                max = Math.max(max, n + length);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        No594 no594 = new No594();
        System.out.println(no594.findLHS(new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }
}