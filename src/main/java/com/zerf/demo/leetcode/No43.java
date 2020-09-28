/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No43
 * Author:   Administrator
 * Date:     20/8/13/0013 9:31
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
public class No43 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        if ("1".equals(num1)) {
            return num2;
        }
        if ("2".equals(num2)) {
            return num1;
        }
        if (num1.length() < num2.length()) {
            String temp = num2;
            num2 = num1;
            num1 = temp;
        }
        StringBuilder nums = new StringBuilder();
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int in = 0;
        for (int i = chars2.length - 1; i >= 0; i--) {
            int c2 = chars2[i] - '0';
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chars2.length - i - 1; j++) {
                sb.append(0);
            }
            for (int j = chars1.length - 1; j >= 0; j--) {
                int c1 = chars1[j] - '0';
                int num = c1 * c2;
                num += in;
                in = num / 10;
                if (num > 9) {
                    num %= 10;
                }
                sb.append(num);
            }
            if (in > 0) {
                sb.append(in);
                in = 0;
            }

            if (nums.length() < 1) {
                nums.append(sb);
            } else {
                getSum(nums, sb);
            }
        }
        return nums.reverse().toString();
    }

    private void getSum(StringBuilder nums, StringBuilder sb) {
        int i = 0;
        int in = 0;
        while (i < nums.length()) {
            int c1 = nums.charAt(i) - '0';
            int c2 = sb.charAt(i) - '0';
            int num = c1 + c2 + in;
            in = num / 10;
            if (num > 9) {
                num %= 10;
            }
            nums.setCharAt(i, (char) (num + '0'));
            i++;
        }

        while (i < sb.length()) {
            int sum = in + (sb.charAt(i) - '0');
            in = sum / 10;
            if (sum > 9) {
                sum %= 10;
            }
            nums.append(sum);
            i++;
        }
        if (in > 0) {
            nums.append(in);
        }

    }

    public static void main(String[] args) {
        No43 no43 = new No43();
        System.out.println(no43.multiply("991", "99999"));
    }
}