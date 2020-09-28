/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No680
 * Author:   Administrator
 * Date:     20/9/16/0016 19:13
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
 * @create 20/9/16/0016
 * @since 1.0.0
 */
public class No680 {
    public boolean validPalindrome(String s) {
        if (s.length() == 0) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l < r) {
            if (chars[l] != chars[r]) {
                return isReverse(chars, l, r - 1) || isReverse(chars, l + 1, r);
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isReverse(char[] chars, int start, int end) {
        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        No680 no680 = new No680();
        System.out.println(no680.validPalindrome("ebcbbececabbacecbbcbes"));
    }
}