package com.luruixiao.code;

import com.luruixiao.structure.ch11.Tree;
import com.sun.javafx.application.HostServicesDelegate;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

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

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     *
     * 给定的 n 保证是有效的。
     *
     * 进阶：
     * 使用一趟扫描实现
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<Integer> nodeList = new ArrayList<>();
        while (head != null) {
            nodeList.add(head.val);
            head = head.next;
        }
        ListNode newNode,header,tailer;
        header = tailer = null;
        for (int i = 0;i < nodeList.size();++i) {
            if ((nodeList.size() - n) != i) {
                newNode = new ListNode(nodeList.get(i));
                if (header == null) {//头永远不动
                    header = tailer = newNode;
                } else {
                    //将新节点连接到链表的尾部
                    tailer.next = newNode;
                    //tailer永远存储最后一个节点的地址
                    tailer = newNode;
                }
            }
        }
        return header;
    }
    /**
     * 优化 一次扫描
     * 前后两个节点 相距n个距离
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode first = head,second = head,tmp = head;
        while (first != null) {
            if (n < 1) {
                tmp = second;
                second = second.next;
            }
            first = first.next;
            n--;
        }
        if (second == head) {
            head = head.next;
        } else {
            tmp.next = second.next;
            second = tmp;
        }
        return head;
    }

    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     * 示例
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        } else if(lists.length == 1) {
            return lists[0];
        } else if(lists.length == 2) {
            return mergeSortListNode(lists[0],lists[1]);
        }
        int middle = lists.length / 2;
        ListNode[] ln1 = new ListNode[middle];
        ListNode[] ln2 = new ListNode[lists.length - middle];
        System.arraycopy(lists, 0, ln1, 0, middle);
        for (int i = middle,j = 0;i < lists.length; i++,j++) {
            ln2[j] = lists[i];
        }
        return mergeSortListNode(mergeKLists(ln1),mergeKLists(ln2));
    }
    /**
     * 链表归并算法
     */
    public static ListNode mergeSortListNode(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        }
        if (listNode2 == null) {
            return listNode1;
        }
        ListNode header = null;
        if (listNode1.val <= listNode2.val) {
            header = listNode1;
            header.next = mergeSortListNode(listNode1.next, listNode2);
        } else {
            header = listNode2;
            header.next = mergeSortListNode(listNode2.next, listNode1);
        }
        return header;
    }

    /**
     * 题 71
     * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
     * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
     * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
     * 示例 1：
     * 输入："/home/"
     * 输出："/home"
     * 解释：注意，最后一个目录名后面没有斜杠。
     * 示例 2：
     * 输入："/../"
     * 输出："/"
     * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
     * 示例 3：
     * 输入："/home//foo/"
     * 输出："/home/foo"
     * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
     * 示例 4：
     * 输入："/a/./b/../../c/"
     * 输出："/c"
     * 示例 5：
     * 输入："/a/../../b/../c//.//"
     * 输出："/c"
     * 示例 6：
     * 输入："/a//b////c/d//././/.."
     * 输出："/a/b/c"
     */
    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (String s : split) {
            switch (s) {
                case "..":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case ".":
                case "":
                case "/":break;
                default:stack.push("/" + s);break;
            }
        }
        if (stack.isEmpty()) stack.push("/");
        StringBuilder rsPath = new StringBuilder();
        while (!stack.isEmpty()) {
            rsPath.insert(0, stack.pop());
        }
        return rsPath.toString();
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    /**
     * 题94
     * 给定一个二叉树，返回它的中序 遍历。
     *
     * 示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [1,3,2]
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arrayList = new ArrayList<>();
        inorderTree(root,arrayList);
        return arrayList;
    }

    public static void inorderTree(TreeNode root,List<Integer> arrayList) {
        if(root != null) {
            inorderTree(root.left, arrayList);
            arrayList.add(root.val);
            inorderTree(root.right, arrayList);
        }
    }

    /**
     * 先序遍历
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arrayList = new ArrayList<>();
        preorderTree(root,arrayList);
        return arrayList;
    }

    public static void preorderTree(TreeNode root,List<Integer> arrayList) {
        if(root != null) {
            arrayList.add(root.val);
            inorderTree(root.left, arrayList);
            inorderTree(root.right, arrayList);
        }
    }

    /**
     * 这题不太会
     * 题95
     * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
     *
     * 示例:
     *
     * 输入: 3
     * 输出:
     * [
     *   [1,null,3,2],
     *   [3,2,null,1],
     *   [3,1,null,null,2],
     *   [2,1,3],
     *   [1,null,2,null,3]
     * ]
     */
    public static List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<TreeNode>();
        }
        return generate_tree(1,n);
    }

    public static List<TreeNode> generate_tree(int start, int end) {
        List<TreeNode> allNodeList = new ArrayList<>();
        if (start > end) {
            allNodeList.add(null);
            return allNodeList;
        }
        for (int i = start;i <= end; i++) {
            List<TreeNode> leftNodeList = generate_tree(start, i - 1);
            List<TreeNode> rightNodeList = generate_tree(i + 1, end);

            for (TreeNode leftNode : leftNodeList) {
                for (TreeNode rightNode : rightNodeList) {
                    TreeNode currentTreeNode = new TreeNode(i);
                    currentTreeNode.left = leftNode;
                    currentTreeNode.right = rightNode;
                    allNodeList.add(currentTreeNode);
                }
            }
        }
        return allNodeList;
    }

    /**
     * 题102 二叉树层次遍历
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rsList = new ArrayList<>();
        Map<Integer,List<Integer>> rsListMap = new HashMap<>();
        LinkedBlockingQueue<TreeNode> treeNodeQueue = new LinkedBlockingQueue<>();
        try {
            treeNodeQueue.put(root);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int n = levelTreePrint(1, treeNodeQueue, rsListMap);
        System.out.println("层数 = " + n);
        for (int i = 1;i <= n;++i) {
            List<Integer> list = rsListMap.get(i);
            if (list != null) {
               rsList.add(list);
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : rsListMap.entrySet()) {
            List<Integer> value = entry.getValue();
            System.out.print(entry.getKey() + " 层---");
            for (Integer i : value) {
                System.out.print(i);
            }
            System.out.println("-----------------");
        }
        return rsList;
    }

    /**
     * 二叉树层次遍历
     * @param n             层数
     * @param treeNodeQueue 队列
     * @param rsListMap     map<层数,list></>
     * @return              层数
     */
    public static int levelTreePrint(int n,LinkedBlockingQueue<TreeNode> treeNodeQueue, Map<Integer,List<Integer>> rsListMap) {
        if (treeNodeQueue.isEmpty()) {
            return n;
        }
        List<Integer> list = null;
        if (rsListMap.containsKey(n)) {
            list = rsListMap.get(n);
        } else {
            list = new ArrayList<>();
            rsListMap.put(n, list);
        }
        TreeNode poll = null;
        try {
            poll = treeNodeQueue.take();
            list.add(poll.val);
            System.out.println(n+ "层-------"+poll.val);
            if (poll.left != null) {
                treeNodeQueue.put(poll.left);
            }
            if (poll.right != null) {
                treeNodeQueue.put(poll.right);
            }
            if (!treeNodeQueue.isEmpty()) {
                levelTreePrint(n+1, treeNodeQueue,rsListMap);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return n + 1;
    }
}
