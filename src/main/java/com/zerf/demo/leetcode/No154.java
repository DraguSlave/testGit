/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No154
 * Author:   Administrator
 * Date:     20/7/22/0022 16:17
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
 * @create 20/7/22/0022
 * @since 1.0.0
 */
public class No154 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }

        }
        return numbers[left];
    }

    public static void main(String[] args) {
        No154 no154 = new No154();
        int[] numbers = {3, 4, 5, 1, 2};
        System.out.println(no154.minArray(numbers));
    }

}