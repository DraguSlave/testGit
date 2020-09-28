/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No350
 * Author:   Administrator
 * Date:     20/7/30/0030 16:11
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
 * @create 20/7/30/0030
 * @since 1.0.0
 */
public class No350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                Integer n = map.get(nums2[i]);
                if (n - 1 == 0) {
                    map.remove(nums2[i]);
                } else {
                    map.put(nums2[i], n - 1);
                }
                list.add(nums2[i]);
            }
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        No350 no350 = new No350();
        int[] nums1 = {43, 85, 49, 2, 83, 2, 39, 99, 15, 70, 39, 27, 71, 3, 88, 5, 19, 5, 68, 34, 7, 41, 84, 2, 13, 85, 12, 54, 7, 9, 13, 19, 92};
        int[] nums2 = {10, 8, 53, 63, 58, 83, 26, 10, 58, 3, 61, 56, 55, 38, 81, 29, 69, 55, 86, 23, 91, 44, 9, 98, 41, 48, 41, 16, 42, 72, 6, 4, 2, 81, 42, 84, 4, 13};
        int[] array = no350.intersect(nums1, nums2);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}