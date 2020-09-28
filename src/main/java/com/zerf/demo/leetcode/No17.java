/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No17
 * Author:   Administrator
 * Date:     20/8/26/0026 9:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 20/8/26/0026
 * @since 1.0.0
 */
public class No17 {
    List[] map = new ArrayList[10];

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        buildMap();
        char[] chars = digits.toCharArray();
        List<Character> letters = map[chars[0] - '0'];
        for (int i = 0; i < letters.size(); i++) {
            list.add(String.valueOf(letters.get(i)));
        }

        for (int i = 1; i < chars.length; i++) {
            ArrayList<String> newList = new ArrayList<>();
            char c = chars[i];
            List<Character> letterList = map[c - '0'];
            for (int j = 0; j < list.size(); j++) {
                for (Character character : letterList) {
                    newList.add(list.get(j) + character);
                }
            }
            list = newList;
        }

        return list;
    }

    private void buildMap() {
        char letter = 'a';
        for (int i = 2; i < 10; i++) {
            int n = 3;
            if (i == 7 || i == 9) {
                n = 4;
            }
            List<Character> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(letter);
                letter++;
                if (letter > 'z') {
                    letter = 'a';
                }
            }
            map[i] = list;
        }
    }

    public static void main(String[] args) {
        No17 no17 = new No17();
        List<String> arr = no17.letterCombinations("234");
        for (String s : arr) {
            System.out.println(s);
        }
        System.out.println(arr.size());

        //[2, 6, 4, 8, 10, 9, 15]
        //2 15
        //
    }
}