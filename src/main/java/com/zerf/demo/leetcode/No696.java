/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No696
 * Author:   Administrator
 * Date:     20/8/10/0010 9:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 20/8/10/0010
 * @since 1.0.0
 */
public class No696 {
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int count = 0;
        char[] chars = s.toCharArray();
        char cur = chars[0];
        int count0 = 0;
        int count1 = 0;

        for (int i = 0; i < chars.length; i++) {
            //10101
            if (chars[i] == cur) {
                count1++;
            } else {
                count0 = count1;
                count1 = 1;
                cur = chars[i];
            }

            if (count1 > 0 && count0 >= count1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        No696 no696 = new No696();
        System.out.println(no696.countBinarySubstrings("10101"));
    }
}