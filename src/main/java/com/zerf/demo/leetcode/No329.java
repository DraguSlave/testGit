/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No329
 * Author:   Administrator
 * Date:     20/7/27/0027 9:24
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
 * @create 20/7/27/0027
 * @since 1.0.0
 */
public class No329 {
    public boolean isSubsequence(String s, String t) {
        //int si = 0;
        //int ti = 0;
        //int left = s.length();
        //while (ti < t.length() && ti + left <= t.length()) {
        //    char sLetter = s.charAt(si);
        //    char tLetter = t.charAt(ti);
        //    if (sLetter == tLetter) {
        //        left--;
        //        si++;
        //    }
        //    if (left == 0) {
        //        return true;
        //    }
        //    ti++;
        //}
        //return false;
        int lastIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            lastIndex = t.indexOf(s.charAt(i), lastIndex + 1);
            if (lastIndex == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No329 no329 = new No329();
        System.out.println(no329.isSubsequence("aaaaaa", "bbaaaa"));
    }
}