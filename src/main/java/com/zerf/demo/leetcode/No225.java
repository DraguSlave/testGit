/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No225
 * Author:   Administrator
 * Date:     20/7/29/0029 11:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.leetcode;

import java.util.LinkedList;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 20/7/29/0029
 * @since 1.0.0
 */
public class No225 {
    private LinkedList<Integer> queue1;

    private LinkedList<Integer> queue2;

    private int last;

    /**
     * Initialize your data structure here.
     */
    public No225() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        last = x;
        queue1.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int num = 0;
        while (!queue1.isEmpty()) {
            if (queue1.size() == 1) {
                num = queue1.removeFirst();
                break;
            }
            if (queue1.size() == 2) {
                last = queue1.getFirst();
            }
            queue2.add(queue1.removeFirst());
        }

        if (!queue2.isEmpty()) {
            queue1 = queue2;
            queue2 = new LinkedList<>();
        }
        return num;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return last;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.size() == 0 && queue2.size() == 0;
    }

    public void out() {
        System.out.println("q1:");
        for (Integer integer : queue1) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println("q2:");
        for (Integer integer : queue2) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        No225 no225 = new No225();
        System.out.println("push1");
        no225.push(1);
        no225.out();
        System.out.println("push2");
        no225.push(2);
        no225.out();
        System.out.println("top");
        System.out.println(no225.top());
        no225.out();
        System.out.println("pop");
        System.out.println(no225.pop());
        no225.out();
        System.out.println("pop");
        System.out.println(no225.pop());
        no225.out();
        System.out.println(no225.empty());
    }
    //["MyStack","push","push","top","pop","pop","empty"]
    //[[],[1],[2],[],[],[],[]]
}