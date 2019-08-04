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
     *
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

    /**
     * 题3
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else if(s.length() == 1) {
            return 1;
        }
        int max = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0;i < s.length();++i) {
            char key = s.charAt(i);
            if (hashMap.get(key) == null) {//不存在
                hashMap.put(key, i);
            } else {
                //value 和 i位置出现重复 移动位置到value
                i = hashMap.get(key);
                max = max < hashMap.size() ? hashMap.size() : max;
                hashMap.clear();
            }
        }
        max = max < hashMap.size() ? hashMap.size() : max;
        return max;
    }

    /**
     * 题3 优化，滑动窗口 采取begin和end定位的方式（没有完成）
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else if(s.length() == 1) {
            return 1;
        }
        int max = 0;
        int begin = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0;i < s.length();++i) {
            char key = s.charAt(i);
            if (hashMap.get(key) == null) {//不存在
                System.out.println(key+"添加");
                hashMap.put(key, i);
            } else {
                //value 和 i位置出现重复 移动位置到value
                int index = hashMap.get(key);
                System.out.println("在" + i + "位置与"+index+"重复" + key);
                max = max < hashMap.size() ? hashMap.size() : max;
                for (int j = begin;j <= index;++j) {
                    System.out.println("移除"+ s.charAt(j));
                    hashMap.remove(s.charAt(j));
                }
                i--;
                begin = index+1;
            }
        }
        max = max < hashMap.size() ? hashMap.size() : max;
        return max;
    }

    /**
     * 题4 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     *
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     *
     * 你可以假设 nums1 和 nums2 不会同时为空。
     *
     * 示例 1:
     *
     * nums1 = [1, 3]
     * nums2 = [2]
     *
     * 则中位数是 2.0
     * 示例 2:
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     *
     * 则中位数是 (2 + 3)/2 = 2.5
     *
     * 解法：根据数组长度知道中位数的位置，因为单个数组有序，则一个一个按照大小获取，直到中位数的位置
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int rsLength = nums1.length + nums2.length;
        //不从零开始
        int middle1 = (rsLength / 2) + 1;
        double rs1 = 0.0;
        double rs2 = 0.0;
        int count = 0;
        int index1 = 0,index2 = 0;//两个数组的移动下标位置
        while(true) {
            rs1 = rs2;
            if (index1 >= nums1.length) {
                rs2 = nums2[index2];
                index2++;
                count++;
            } else if(index2 >= nums2.length) {
                rs2 = nums1[index1];
                index1++;//nums1进1
                count++;
            } else if (nums1[index1] < nums2[index2]) {
                rs2 = nums1[index1];
                index1++;//nums1进1
                count++;
            } else {
                rs2 = nums2[index2];
                index2++;
                count++;
            }
            if (count == middle1) {
                break;
            }
        }
        if (rsLength % 2 == 0) {//中位数需要两个数计算
            return (rs1 + rs2) / 2.0;
        }
        return rs2;
    }

    /**
     * 获取一个有序数组中的中位数
     */
    private static double getMiddle1Arr(int[] nums1) {
        double middle1;
        if (nums1 == null || nums1.length == 0) {
            middle1 = 0.0;
        } else if (nums1.length == 1) {
            middle1 = nums1[0];
        } else {
            if (nums1.length % 2 == 0) {//偶数个
                int index1 = (nums1.length / 2) - 1;
                int index2 = nums1.length / 2;
                middle1 = ((nums1[index1] + nums1[index2]) * 1.0) / 2.0;
            } else {
                int index2 = nums1.length / 2;
                middle1 = nums1[index2];
            }
        }
        System.out.println("中位数="+middle1);
        return middle1;
    }
}
