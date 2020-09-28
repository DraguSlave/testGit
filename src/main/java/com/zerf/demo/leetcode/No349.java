/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No349
 * Author:   Administrator
 * Date:     20/7/30/0030 15:09
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.leetcode;

import org.apache.poi.ss.formula.functions.T;

import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 20/7/30/0030
 * @since 1.0.0
 */
public class No349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                list.add(nums2[i]);
            }
        }
        int[] array = new int[list.size()];
        Integer[] objects = list.toArray(new Integer[0]);
        for (int i = 0; i < list.size(); i++) {
            array[i] = objects[i];
        }
        return array;
    }

    public static void main(String[] args) {
        No349 no349 = new No349();
        int[] nums1 = {9, 4, 9, 8, 4};
        int[] nums2 = {4, 9, 5};
        int[] array = no349.intersection(nums1, nums2);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}