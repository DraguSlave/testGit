/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No205
 * Author:   Administrator
 * Date:     20/7/28/0028 14:29
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
 * @create 20/7/28/0028
 * @since 1.0.0
 */
public class No205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> maps = new HashMap<>();
        Map<Character, Integer> mapt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sLetter = s.charAt(i);
            char tLetter = t.charAt(i);

            if (maps.containsKey(sLetter) == mapt.containsKey(tLetter)) {
                if (maps.get(sLetter) != mapt.get(tLetter)) {
                    return false;
                }

                maps.put(sLetter, i);
                mapt.put(tLetter, i);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        No205 no205 = new No205();
        System.out.println(no205.isIsomorphic("aba", "cdc"));
    }
}