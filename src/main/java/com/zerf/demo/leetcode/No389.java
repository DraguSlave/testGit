/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No389
 * Author:   Administrator
 * Date:     20/7/31/0031 14:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 20/7/31/0031
 * @since 1.0.0
 */
public class No389 {
    public char findTheDifference(String s, String t) {
        StringBuffer sbs = new StringBuffer(s);
        StringBuffer sbt = new StringBuffer(t);

        int i = 0;
        while (sbt.length() > 1) {
            char a = sbs.charAt(i);
            int j = sbt.indexOf(String.valueOf(a));
            if (j == -1) {
                return a;
            }
            sbs.replace(i, i + 1, "");
            sbt.replace(j, j + 1, "");
            System.out.println(sbs.toString());
            System.out.println(sbt.toString());
        }
        return 'a';
    }

    public char findTheDifference1(String s, String t) {
        int sums = 0;
        int sumt = 0;

        for (int i = 0; i < s.length(); i++) {
            sums += s.charAt(i);
            sumt += t.charAt(i);
        }
        sumt += t.charAt(t.length() - 1);

        return (char) (sumt - sums);
    }

    public char findTheDifference2(String s, String t) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum ^= c;
        }

        for (char c : t.toCharArray()) {
            sum ^= c;
        }

        return (char) sum;
    }

    public char findTheDifference3(String s, String t) {
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();

        Arrays.sort(sarr);
        Arrays.sort(tarr);

        for (int i = 0; i < sarr.length; i++) {
            if (sarr[i] != tarr[i]) {
                return tarr[i];
            }
        }

        return tarr[t.length() - 1];
    }

    public char findTheDifference4(String s, String t) {
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();

        int sum = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            sum ^= sarr[i];
            sum ^= tarr[i];
        }
        sum ^= tarr[t.length() - 1];

        return (char) sum;
    }

    public static void main(String[] args) {
        No389 no389 = new No389();
        System.out.println(no389.findTheDifference2("aaa", "aaaa"));
    }
}