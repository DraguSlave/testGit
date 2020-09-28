/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No492
 * Author:   Administrator
 * Date:     20/8/14/0014 15:13
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
 * @create 20/8/14/0014
 * @since 1.0.0
 */
public class No492 {
    public int[] constructRectangle(int area) {
        if (area == 0) {
            return new int[]{};
        }
        int min = (int) Math.sqrt(area);
        while (area % min != 0) {
            min--;
        }
        return new int[]{area / min, min};
    }

    public static void main(String[] args) {
        No492 no492 = new No492();
        int[] ints = no492.constructRectangle(9);
        System.out.println(ints[0] + " " + ints[1]);
    }
}