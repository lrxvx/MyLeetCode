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
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode r = null;
//        int val1 = l1.val;
//        int n1 = 10;
//        ListNode node = l1.next;
//        while (node != null) {
//            val1 = node.val * n1 + val1;
//            n1 = n1 * 10;
//            node = node.next;
//        }
        int val1 = 0;
        int n1 = 1;
        ListNode node1 = l1;
        ArrayList<Integer> node1Arr = new ArrayList<>();
        while (node1 != null) {
            node1Arr.add(node1.val);
            node1 = node1.next;
        }
        for (Integer rs : node1Arr) {
            val1 = val1 + rs * n1;
            n1 = n1 * 10;
        }

        int val2 = 0;
        int n2 = 1;
        ListNode node2 = l2;
        ArrayList<Integer> node2Arr = new ArrayList<>();
        while (node2 != null) {
            node2Arr.add(node2.val);
            node2 = node2.next;
        }
        for (Integer rs : node2Arr) {
            System.out.println("rs = " + rs + " val2 = " + val2 + " n2 = " + n2);
            val2 = val2 + rs * n2;
            System.out.println("val2 = " + val2);
            n2 = n2 * 10;
        }
        System.out.println( " val2 = " + val2 + " n2 = " + n2);

        int result =  val1 + val2;
        System.out.println(val1 + " + " + val2 + " = " + result);
        ArrayList<Integer> integers = new ArrayList<>();
        while (result >= 10) {
            int num = result % 10;
            result = result / 10;
            integers.add(num);
        }
        integers.add(result);
        for (int i = integers.size()-1;i >= 0;i--) {
            ListNode s = new ListNode(integers.get(i));
            s.next = r;
            r = s;
        }
        return r;
    }
}
