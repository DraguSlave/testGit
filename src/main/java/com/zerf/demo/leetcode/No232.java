/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No232
 * Author:   Administrator
 * Date:     20/7/29/0029 15:16
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
public class No232 {
    private LinkedList<Integer> stack1;

    private LinkedList<Integer> stack2;

    Integer top;

    /** Initialize your data structure here. */
    public No232() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (top == null) {
            top = x;
        }
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack1.size() == 1) {
            top = null;
            return stack1.pop();
        }
        //1234
        //1 2 3
        //1 3 null

        //123
        //1 2 3
        //1 3
        while (!stack1.isEmpty()) {
            if (stack1.size() == 2) {
                top = stack1.peek();
            }
            stack2.push(stack1.pop());
        }
        int num = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return num;
    }

    /** Get the front element. */
    public int peek() {
        return top;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }

    public void out(){
        for (Integer integer : stack1) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        No232 no232 = new No232();
        no232.push(1);
        no232.out();
        no232.pop();
        no232.out();
        no232.push(2);
        no232.out();
        System.out.println(no232.peek());
        no232.out();
    }
}