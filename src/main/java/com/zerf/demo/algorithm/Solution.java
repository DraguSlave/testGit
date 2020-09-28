/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Solution
 * Author:   Administrator
 * Date:     20/7/6/0006 10:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.algorithm;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author Administrator
 * @create 20/7/6/0006
 * @since 1.0.0
 */
public class Solution {
    //字典替换
    public int respace(String[] dictionary, String sentence) {
        for (String aDictionary : dictionary) {
            sentence = sentence.replaceFirst(aDictionary, " 1 ");
            System.out.println(sentence);
        }
        String[] strings = sentence.split(" ");
        int count = 0;
        for (String string : strings) {
            if (StringUtils.isNotEmpty(string)) {
                count++;
            }
        }
        return count;
    }

    //二分查询算根号
    public int mySqrt(int x) {
        if (x == 1 || x == 0) {
            return x;
        }
        long left = 1;
        long right = x;
        long temp;
        long result;
        do {
            temp = (right + left) / 2;
            result = temp * temp;
            System.out.println(left + "   " + right + "   " + temp + "   ");
            if (result > x) {
                right = temp;
            }
            if (result < x) {
                if ((temp + 1) * (temp + 1) > x) {
                    return (int) temp;
                }
                left = temp;
            }
            if (result == x) {
                return (int) temp;
            }
        } while (true);
    }

    public void paixu(int n) {
        long begintime = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        String str = sb.toString();
        System.out.println(sb);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < sb.length() - 1; j++) {
                char letter = sb.charAt(j + 1);
                sb.setCharAt(j + 1, sb.charAt(j));
                sb.setCharAt(j, letter);
                if (!str.equals(sb.toString())) {
                    System.out.println(sb);
                }
            }
        }
        long endtime = System.nanoTime();
        System.out.println((endtime - begintime) / 1000);
    }

    public String addBinary(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        boolean biga = lengthA >= lengthB;
        if (!biga) {
            String c = a;
            a = b;
            b = c;
            lengthA = a.length();
            lengthB = b.length();
        }

        int indexA = lengthA - 1;
        int indexB = lengthB - 1;
        //char temp = a.charAt(indexA) == '1' && b.charAt(indexB) == '1' ? '1' : '0';
        char temp = '0';

        StringBuffer sb = new StringBuffer(a);
        while (indexB >= 0) {
            char letterA = a.charAt(indexA);
            char letterB = b.charAt(indexB);
            if (letterA == letterB) {
                if (letterA == '1') {
                    sb.setCharAt(indexA, temp);
                    temp = temp == '1' ? '1' : '0';
                } else {
                    sb.setCharAt(indexA, temp);
                    temp = '0';
                }
            } else {
                sb.setCharAt(indexA, temp == '1' ? '0' : '1');
            }

            indexA--;
            indexB--;
        }

        while (temp == '1' && indexA >= 0) {
            char letterA = a.charAt(indexA);
            if (letterA == '1') {
                sb.setCharAt(indexA, '0');
            } else {
                sb.setCharAt(indexA, '1');
                return sb.toString();
            }
            indexA--;
        }

        return '1' + sb.toString();
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> triangleChildCurrent = null;
        int[] nums = new int[(triangle.get(triangle.size() - 1)).size()];
        nums[0] = triangle.get(0).get(0);
        /**
         *      [2],
         *     [3,4],
         *    [6,5,7],
         *   [4,1,8,3]
         *  [2]
         *  [5, 6]
         *  [11, 10, 13]
         *  [15, 11, 18, 16]
         */
        for (int i = 1; i < triangle.size() - 1; i++) {
            triangleChildCurrent = triangle.get(i);
            for (int j = triangleChildCurrent.size() - 1; j >= 0; j--) {
                if (j == triangleChildCurrent.size() - 1) {
                    nums[j] = nums[j - 1] + triangleChildCurrent.get(j);
                }
                if (j == 0) {
                    nums[j] += triangleChildCurrent.get(j);
                }
                if (0 < j && j < triangleChildCurrent.size() - 1) {
                    nums[j] = Math.min(nums[j], nums[j - 1]) + triangleChildCurrent.get(j);
                }
            }

            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[j]);
                if (nums[j] != nums.length - 1) {
                    System.out.print(", ");
                } else {
                    System.out.println();
                }
            }
        }

        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        //String[] dictionary = {"looked", "just", "like", "her", "brother"};
        //String sentence = "jesslookedjustliketimherbrother";
        //System.out.println(solution.respace(dictionary, sentence));
        //System.out.println(solution.mySqrt(2147395599));
        //solution.paixu(9);
        //System.out.println(solution.addBinary("11", "1"));
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> triangleChild1 = new ArrayList<>();
        triangleChild1.add(2);
        List<Integer> triangleChild2 = new ArrayList<>();
        triangleChild2.add(3);
        triangleChild2.add(4);
        List<Integer> triangleChild3 = new ArrayList<>();
        triangleChild3.add(6);
        triangleChild3.add(5);
        triangleChild3.add(7);
        List<Integer> triangleChild4 = new ArrayList<>();
        triangleChild4.add(4);
        triangleChild4.add(1);
        triangleChild4.add(8);
        triangleChild4.add(3);
        triangle.add(triangleChild1);
        triangle.add(triangleChild2);
        triangle.add(triangleChild3);
        triangle.add(triangleChild4);

        System.out.println(solution.minimumTotal(triangle));

    }
}