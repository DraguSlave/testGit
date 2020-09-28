/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No155
 * Author:   Administrator
 * Date:     20/7/23/0023 15:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 20/7/23/0023
 * @since 1.0.0
 */
public class No155 {
    private List<Integer> stack;

    private List<Integer> minNumStack;

    public No155() {
        stack = new ArrayList<>();
        minNumStack = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(x);
        if (minNumStack != null && minNumStack.size() > 0) {
            minNumStack.add(Math.min(minNumStack.get(minNumStack.size() - 1), x));
        } else {
            minNumStack.add(x);
        }
    }

    public void pop() {
        if (stack != null && stack.size() > 0) {
            stack.remove(stack.size() - 1);
            minNumStack.remove(minNumStack.size() - 1);
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return minNumStack.get(minNumStack.size() - 1);
    }
}
