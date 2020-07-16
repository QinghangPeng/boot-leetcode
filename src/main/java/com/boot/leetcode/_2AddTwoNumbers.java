package com.boot.leetcode;

import java.util.List;
import java.util.Stack;

/**
 * @ClassName: _2AddTwoNumbers
 * @Description:
 * @Author: jackson
 * @Date: 2020/7/15 下午2:56
 * @Version: v1.0
 */
public class _2AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
    //
    // 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    //
    // 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    //
    // 示例：
    //
    // 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    //输出：7 -> 0 -> 8
    //原因：342 + 465 = 807
    //
    // Related Topics 链表 数学

    /**
     *  逆向链表
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbersReverse(ListNode l1,ListNode l2) {
        //定义一个结果链表
        ListNode result = new ListNode(0);
        //定义一个中间量链表
        ListNode temp = result;
        //定义进位标识
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            //计算每一位的值时，需要加上从上一位的进位
            int sum = x + y + carry;
            //计算进位
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //循环完成后，需要判断是否还有进位，有进位需要增加链表
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return result.next;
    }

    /**
     *  顺向链表
     *  如果链表中的数字不是按逆序存储的呢？例如：
     *
     * (3 -> 4 ->2) + (4 -> 6 -> 5) = 8 -> 0 -> 7
     * (3→4→2)+(4→6→5)=8→0→7
     *
     * @return
     */
    public static ListNode addTwoNumbersForward(ListNode l1,ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int carry = 0;
        //利用栈先进后出的原理，将顺向链表组装成栈
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                s1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                s2.push(l2.val);
                l2 = l2.next;
            }
        }

        while (!s1.empty() || !s2.empty()) {
            int x = !s1.empty() ? s1.pop() : 0;
            int y = !s2.empty() ? s2.pop() : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            //利用头插法，将结果按照从高位到地位顺序插入
            ListNode node = new ListNode(sum % 10);
            node.next = temp.next;
            temp.next = node;
        }

        if (carry > 0) {
            ListNode node = new ListNode(carry);
            node.next = temp.next;
            temp.next = node;
        }

        return result.next;
    }

    public static ListNode buildListNode(int[] nums) {
        ListNode node = new ListNode(0);
        ListNode temp = node;
        for (int num : nums) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        return node.next;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {2,4,3};
        int[] nums2 = new int[] {5,6,4};
        int[] nums3 = new int[] {3,4,2};
        int[] nums4 = new int[] {4,6,5};
        ListNode node1 = buildListNode(nums1);
        ListNode node2 = buildListNode(nums2);
        ListNode node3 = buildListNode(nums3);
        ListNode node4 = buildListNode(nums4);

        ListNode listNode = addTwoNumbersReverse(node1, node2);
        ListNode listNode1 = addTwoNumbersForward(node3, node4);

        System.out.println("逆序打印==============");
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

        System.out.println("顺序打印==============");
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }

    }
}
