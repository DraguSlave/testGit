/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No141
 * Author:   Administrator
 * Date:     20/7/23/0023 14:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 20/7/23/0023
 * @since 1.0.0
 */
public class No141 {
    public boolean hasCycle(ListNode head) {
        //if (head == null) {
        //    return false;
        //}
        //Set<ListNode> set = new HashSet<>();
        //while (head.next != null) {
        //    if (!set.add(head)) {
        //        return true;
        //    }
        //    head = head.next;
        //}
        //return false;
        if (head == null) {
            return false;
        }

        while (head.next != null) {
            if (head.next.next != null) {
                head.next = head.next.next;
            }
            if (head == head.next) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        No141 no141 = new No141();
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        System.out.println(no141.hasCycle(head));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}