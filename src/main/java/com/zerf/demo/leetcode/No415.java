/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No415
 * Author:   Administrator
 * Date:     20/8/3/0003 17:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.leetcode;

import java.util.Calendar;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 20/8/3/0003
 * @since 1.0.0
 */
public class No415 {
    public String addStrings(String num1, String num2) {
        while (num1.length() > num2.length()) {
            num2 = "0" + num2;
        }

        while (num1.length() < num2.length()) {
            num1 = "0" + num1;
        }

        char[] cs1 = num1.toCharArray();
        char[] cs2 = num2.toCharArray();
        int in = 0;
        int i = 0;

        StringBuilder sb = new StringBuilder();
        int l1 = cs1.length - 1;
        int l2 = cs2.length - 1;

        while (i < num1.length()) {
            int n1 = cs1[l1 - i] - '0';
            int n2 = cs2[l2 - i] - '0';
            int sum = n1 + n2 + in;
            if (sum > 9) {
                sb.append(sum % 10);
                in = 1;
            } else {
                in = 0;
                sb.append(sum);
            }
            i++;
        }

        if (in > 0) {
            sb.append(1);
        }

        sb.reverse();

        return sb.toString();
    }

    public static void main(String[] args) {
        No415 no415 = new No415();
        System.out.println(no415.addStrings("1999", "101"));
        //2100
    }
}