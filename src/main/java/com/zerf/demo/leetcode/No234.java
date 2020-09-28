/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: No234
 * Author:   Administrator
 * Date:     20/7/29/0029 16:18
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
 * @create 20/7/29/0029
 * @since 1.0.0
 */
public class No234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        //创建快慢指针
        ListNode slow = head, fast = head;
        ListNode cur = head, pre = null;
        //快走2,慢走1,这样快走完,慢为中点
        while (fast != null && fast.next != null) {
            cur = slow;
            slow = slow.next;
            fast = fast.next.next;
            //将前半段反转
            cur.next = pre;
            pre = cur;
        }
        //如果长度为奇数,fast!=null,故将慢指针移动一位,不判断中点
        if (fast != null) {
            slow = slow.next;
        }
        //这边继续遍历,用前面反转的前半段比较后半段
        while (cur != null && slow != null) {
            if (cur.val != slow.val) {
                return false;
            }
            cur = cur.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        No234 no234 = new No234();

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);

        head.next = node1;
        node1.next = node2;

        no234.isPalindrome(head);
    }
}