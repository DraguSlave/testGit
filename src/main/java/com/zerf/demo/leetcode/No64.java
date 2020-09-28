/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No64
 * Author:   Administrator
 * Date:     20/7/23/0023 9:01
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
 * @create 20/7/23/0023
 * @since 1.0.0
 */
public class No64 {
    public int minPathSum(int[][] grid) {
        int y = grid.length;
        int x = grid[0].length;
        int[] currentMinSum = new int[x];
        for (int i = 0; i < y; i++) {
            if (i == 0) {
                currentMinSum[0] = grid[0][0];
                for (int j = 1; j < x; j++) {
                    currentMinSum[j] = currentMinSum[j - 1] + grid[0][j];
                }
            } else {
                currentMinSum[0] += grid[i][0];
                for (int j = 1; j < x; j++) {
                    currentMinSum[j] = Math.min(currentMinSum[j - 1], currentMinSum[j]) + grid[i][j];
                }
            }

            for (int j = 0; j < x; j++) {
                System.out.print(currentMinSum[j] + " ");
            }
            System.out.println();
        }
        return currentMinSum[x - 1];
    }

    public static void main(String[] args) {
        No64 no64 = new No64();
        int[][] grid = {{1, 2, 5}, {3, 2, 1}};
        System.out.println(no64.minPathSum(grid));
    }
}