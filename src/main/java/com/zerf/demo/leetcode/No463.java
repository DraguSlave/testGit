/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No463
 * Author:   Administrator
 * Date:     20/8/13/0013 9:17
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
 * @create 20/8/13/0013
 * @since 1.0.0
 */
public class No463 {
    public int islandPerimeter(int[][] grid) {
        int y = grid.length;
        int x = grid[0].length;
        int count = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (grid[i][j] == 1) {
                    count += 4;

                    if (i != 0 && grid[i - 1][j] == 1) {
                        count -= 2;
                    }
                    if (j != 0 && grid[i][j - 1] == 1) {
                        count -= 2;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        No463 no463 = new No463();
        int[][] grid =
                {
                        {0, 1, 0, 0},
                        {1, 1, 1, 1},
                        {0, 1, 0, 1},
                        {1, 1, 0, 0}
                };
        System.out.println(no463.islandPerimeter(grid));
    }
}