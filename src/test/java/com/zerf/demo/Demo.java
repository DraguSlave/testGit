/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Demo
 * Author:   Administrator
 * Date:     20/7/3/0003 11:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 20/7/3/0003
 * @since 1.0.0
 */
public class Demo {

    public String countAndSay(int n) {
        String str = "1";
        if (n == 1) {
            return str;
        }
        if (n == 2) {
            str = "11";
            return str;
        }

        for (int i = 2; i <= n; i++) {
            char letter = str.charAt(0);
            int index = 0;
            StringBuffer sb = new StringBuffer();
            for (int j = 1; j < str.length(); j++) {

                if (letter != str.charAt(j) || j == str.length() - 1) {
                    sb.append(j - index + 1);
                    sb.append(letter);
                }
            }
            str = sb.toString();
        }
        return str;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println(demo.countAndSay(4));
    }
}