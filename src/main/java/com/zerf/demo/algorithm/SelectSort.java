/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SelectSort
 * Author:   Administrator
 * Date:     19/6/19/0019 15:37
 * Description: 选择排序
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.algorithm;

/**
 * 〈一句话功能简述〉<br>
 * 〈选择排序〉
 *
 * @author Administrator
 * @create 19/6/19/0019
 * @since 1.0.0
 */
public class SelectSort {
    private static void selectSort(int[] array) {
        //每次查询一个最小的数
        for (int i = 0; i < array.length - 1; i++) {
            int temp = array[i];
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (temp > array[j]) {
                    temp = array[j];
                    index = j;
                }
            }
            array[index] = array[i];
            array[i] = temp;
            print(array);
        }
    }

    private static void print(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {5, 4, 6, 4, 2};
        print(array);
        selectSort(array);
        //print(array);
    }
}