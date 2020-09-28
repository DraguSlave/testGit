/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No482
 * Author:   Administrator
 * Date:     20/8/14/0014 14:17
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
 * @create 20/8/14/0014
 * @since 1.0.0
 */
public class No482 {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();
        int count = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            char letter = chars[i];
            if ('-' != letter) {
                if (!Character.isUpperCase(letter)) {
                    letter = Character.toUpperCase(letter);
                }
                if (count == K) {
                    sb.append("-");
                    count = 0;
                }
                sb.append(letter);
                count++;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        No482 no482 = new No482();
        System.out.println(no482.licenseKeyFormatting("5F3Z-2e-9-w2", 4));
        //5F3Z-2E9W
    }
}