/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No125
 * Author:   Administrator
 * Date:     20/7/23/0023 10:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.leetcode;

import java.util.LinkedList;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 20/7/23/0023
 * @since 1.0.0
 */
public class No125 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char l = changeBig(s.charAt(left));
            char r = changeBig(s.charAt(right));
            boolean flag = false;
            if (l == 32 || !check(l)) {
                flag = true;
                left++;
            }
            if (r == 32 || !check(r)) {
                flag = true;
                right--;
            }
            if (flag) {
                continue;
            }
            if (l != r) {
                System.out.println(l + " " + r);
                return false;
            }
            left++;
            right--;

        }
        return true;
    }

    private boolean check(char letter) {
        //数字48~57
        //大写字母65~90
        //小写字母97~122
        if (letter >= 48 && letter <= 57) {
            return true;
        }
        if (letter >= 97 && letter <= 122) {
            return true;
        }

        return false;
    }

    private char changeBig(char letter) {
        if (letter >= 65 && letter <= 90) {
            return (char) (letter + 32);
        }
        return letter;
    }

    public static void main(String[] args) {
        No125 no125 = new No125();
        System.out.println(no125.isPalindrome("A man, a plan, a canal: Panama"));
    }
}