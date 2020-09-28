/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No447
 * Author:   Administrator
 * Date:     20/8/11/0011 15:34
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
 * @create 20/8/11/0011
 * @since 1.0.0
 */
public class No447 {
    public int numberOfBoomerangs(int[][] points) {
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double x = Math.pow(Math.abs(points[0][j] - points[0][i]), 2);
                double y = Math.pow(Math.abs(points[1][j] - points[1][i]), 2);
                // todo
            }
        }
        return 4;
    }

    public static void main(String[] args) {
        No447 no447 = new No447();
        int[][] points = {{0, 0}, {1, 0}, {2, 0}, {2, 2}, {3, 3}};
        System.out.println(no447.numberOfBoomerangs(points));
    }
}