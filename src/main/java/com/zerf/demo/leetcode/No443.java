/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No443
 * Author:   Administrator
 * Date:     20/8/11/0011 14:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.leetcode;

import static org.apache.xml.security.keys.keyresolver.KeyResolver.length;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 20/8/11/0011
 * @since 1.0.0
 */
public class No443 {
    public int compress(char[] chars) {
        if (chars.length < 2) {
            return chars.length;
        }
        int count = 1;
        char last = chars[0];
        int lastIndex = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != last) {
                chars[lastIndex] = last;
                lastIndex++;
                if (count > 1) {
                    String s = String.valueOf(count);
                    char[] array = s.toCharArray();
                    for (int j = 0; j < array.length; j++) {
                        chars[lastIndex] = array[j];
                        lastIndex++;
                    }
                    count = 1;
                }
                last = chars[i];
            } else {
                count++;
            }
        }
        if (count > 0) {
            chars[lastIndex] = last;
            if (count > 1) {
                String s = String.valueOf(count);
                char[] array = s.toCharArray();
                for (int j = 0; j < array.length; j++) {
                    lastIndex++;
                    chars[lastIndex] = array[j];
                }
            }
        }
        return lastIndex + 1;
    }

    public static void main(String[] args) {
        No443 no443 = new No443();
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int compress = no443.compress(chars);
        System.out.println(compress);
        for (int i = 0; i < compress; i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ");
        }
    }
}