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
public class No119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> nums = new ArrayList<>();
        if (rowIndex == 0) {
            return nums;
        }
        nums.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            nums.add(1);
            for (int j = nums.size() - 2; j > 0; j--) {
                nums.set(j, nums.get(j - 1) + nums.get(j));
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        No119 no118 = new No119();
        List<Integer> list = no118.getRow(5);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}