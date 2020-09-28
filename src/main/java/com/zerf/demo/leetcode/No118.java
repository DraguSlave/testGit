/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No118
 * Author:   Administrator
 * Date:     20/7/21/0021 17:46
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
 * @create 20/7/21/0021
 * @since 1.0.0
 */
public class No118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> numss = new ArrayList<>();
        if (numRows == 0) {
            return numss;
        }
        List<Integer> numsFirst = new ArrayList<>();
        numsFirst.add(1);
        numss.add(numsFirst);
        for (int i = 1; i < numRows; i++) {
            List<Integer> nums = new ArrayList<>();
            List<Integer> numsLast = numss.get(i - 1);
            nums.add(1);
            for (int j = 1; j < i; j++) {
                nums.add(numsLast.get(j - 1) + numsLast.get(j));
            }
            nums.add(1);
            numss.add(nums);
        }
        return numss;
    }

    public static void main(String[] args) {
        No118 no118 = new No118();
        List<List<Integer>> list = no118.generate(5);
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}