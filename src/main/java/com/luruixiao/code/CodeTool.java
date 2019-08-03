package com.luruixiao.code;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 力扣的算法题
 */
public class CodeTool {

    /** 题目1
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0;i < nums.length;++i) {
            for (int j = 0;j < nums.length;++j) {
                if(i != j) {
                    if (nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                        break;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 题目1，哈希优化
     */
    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        for (int i = 0;i < nums.length;++i) {
            int compare = target - nums[i];
            if (hashMap2.containsKey(compare)) {
                return new int[]{hashMap2.get(compare),i};
            }
            hashMap2.put(nums[i], i);
        }
        return result;
    }

    /**
     * 题目2
     */
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    /**
     *给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 使用统计数值再转变成链表不行，数据类型长度不够
     * 使用对应的位置进行计算，按照10进制，建立一个新的链表
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode newNode,header,tailer;
        header = tailer = null;

        boolean flag = false;//记录是否存在进位情况，有进位则下一次加一
        while (l1 != null || l2 != null) {
            int val1 = 0;
            int val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            int rs = val1 + val2;
            if (flag) {
                rs++;
                flag = false;
            }
            if (rs < 10) {
                newNode = new ListNode(rs);
            } else {
                newNode = new ListNode(rs-10);
                flag = true;
            }
            if (header == null) {//头永远不动
                header = tailer = newNode;
            } else {
                //将新节点连接到链表的尾部
                tailer.next = newNode;
                //tailer永远存储最后一个节点的地址
                tailer = newNode;
            }
        }
        if (flag) {//最后一位都有进位时单独添加一个节点
            newNode  = new ListNode(1);
            if (header == null) {//头永远不动
                header = newNode;
            } else {
                //将新节点连接到链表的尾部
                tailer.next = newNode;
                //tailer永远存储最后一个节点的地址
                tailer = newNode;
            }
        }
        return header;
    }
}
