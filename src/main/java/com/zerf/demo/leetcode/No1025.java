/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No1025
 * Author:   Administrator
 * Date:     20/7/24/0024 9:45
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
 * @create 20/7/24/0024
 * @since 1.0.0
 */
public class No1025 {
    public boolean divisorGame(int N) {
        boolean success = true;
        while (N != 2) {
            int x = N - 1;
            while (N % x != 0) {
                x--;
            }
            N = N - x;
            success = !success;
        }
        return success;
    }

    public static void main(String[] args) {
        No1025 no1025 = new No1025();
        //1 1 2
        //
        System.out.println(no1025.divisorGame(4));
    }
}