/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SelectSort2
 * Author:   Administrator
 * Date:     19/6/24/0024 10:13
 * Description: 二元选择排序
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.algorithm;

/**
 * 〈一句话功能简述〉<br>
 * 〈二元选择排序〉
 *
 * @author Administrator
 * @create 19/6/24/0024
 * @since 1.0.0
 */
public class SelectSort2 {
    private static void selectSort2(int[] array) {
        //选择排序改进,每趟循环找出最大跟最小
        for (int i = 0; i < array.length - i; i++) {
            int minIndex = i;
            int min = array[minIndex];
            int maxIndex = array.length - i - 1;
            int max = array[maxIndex];
            if(minIndex == maxIndex){
                break;
            }
            for (int j = i; j < array.length - i; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
                if (array[j] > max) {
                    max = array[j];
                    maxIndex = j;
                }
            }
            System.out.println("min:" + min + "  minIndex:" + minIndex);
            System.out.println("max:" + max + "  maxIndex:" + maxIndex);

            array[minIndex] = array[i];
            array[i] = min;
            //这里要注意一下,如果maxIndex在假定最小位置i上,那么第一次最小值交换完后,真正的maxIndex已经变了
            //就是第一次的交换干扰到了第二次的交换
            if (i == maxIndex) {
                maxIndex = minIndex;
            }

            array[maxIndex] = array[array.length - i - 1];
            array[array.length - i - 1] = max;

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
        //int[] array = {5, 4, 6, 4, 2};
        //int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] array = {62, 4, 2, 234, 6, 24, 6, 724, 7, 34, 3, 4};
        print(array);
        selectSort2(array);
        //print(array);
    }
}