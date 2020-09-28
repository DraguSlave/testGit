/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No160
 * Author:   Administrator
 * Date:     20/7/24/0024 15:53
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
 * @create 20/7/24/0024
 * @since 1.0.0
 */
public class No160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }

        return nodeA;
    }

    public static void main(String[] args) {
        No160 no160 = new No160();
        ListNode headA = new ListNode(4);
        ListNode nodeA1 = new ListNode(1);

        ListNode headB = new ListNode(5);
        ListNode nodeB1 = new ListNode(6);
        ListNode nodeB2 = new ListNode(1);

        ListNode publicNode1 = new ListNode(8);
        ListNode publicNode2 = new ListNode(4);
        ListNode publicNode3 = new ListNode(5);

        headA.next = nodeA1;
        nodeA1.next = publicNode1;

        headB.next = nodeB1;
        nodeB1.next = nodeB2;
        nodeB2.next = publicNode1;
        publicNode1.next = publicNode2;
        publicNode2.next = publicNode3;

        System.out.println(no160.getIntersectionNode(headA, headB).val);
    }
}