package com.luruixiao.demo;

import com.luruixiao.code.CodeTool;
import org.junit.Test;

import java.util.List;

/**
 *
 */
public class CodeDemo {

    /**
     * 题2
     */
    @Test
    public void Test2(){
        int[] arr1 = {9};
        int[] arr2 = {1,9,9,9,9,9,9,9,9,9};
        CodeTool.ListNode node1 = fillNode(arr1);
        CodeTool.ListNode node2 =  fillNode(arr2);

        CodeTool.ListNode node = CodeTool.addTwoNumbers(node1, node2);
        while (node2!=null) {
            System.out.print(node2.val + " ");
            node2 = node2.next;
        }
        System.out.println();
        while (node!=null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    /**
     * 尾插法
     */
    private static CodeTool.ListNode fillNode(int[] arr) {
        CodeTool.ListNode newNode,header,tailer;
        header = tailer = null;
        for (int i : arr) {
            newNode = new CodeTool.ListNode(i);
            if (header == null) {//头永远不动
                header = tailer = newNode;
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
     */
    @Test
    public void Test3() {
        int num = CodeTool.lengthOfLongestSubstring2("abcabcbb");
        System.out.println(num);
    }

    @Test
    public void Test4() {
        int num1[] = {1};
        int num2[] = {3,4,5,6,7};
        System.out.println(CodeTool.findMedianSortedArrays(num1, num2));
    }

    /**
     * 题 19
     */
    @Test
    public void Test19() {
        int[] arr2 = {1};
//        int[] arr2 = {1,2,3,4,5};
        CodeTool.ListNode node1 = fillNode(arr2);
        CodeTool.ListNode node = CodeTool.removeNthFromEnd2(node1, 1);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    /**
     * 题 23
     */
    @Test
    public void Test23() {
        int[] arr1 = {1,4,5};
        int[] arr2 = {1,3,4};
        int[] arr3 = {2,6};
        CodeTool.ListNode node1 = fillNode(arr1);
        CodeTool.ListNode node2 = fillNode(arr2);
        CodeTool.ListNode node3 = fillNode(arr3);
        CodeTool.ListNode[] nodes = {node1,node2,node3};
        CodeTool.ListNode node = CodeTool.mergeKLists(nodes);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    /**
     * 题 71
     */
    @Test
    public void Test71() {
        System.out.println(CodeTool.simplifyPath("/a//b////c/d//././/.."));
    }

    @Test
    public void Test94() {
        CodeTool.TreeNode treeNode1 = new CodeTool.TreeNode(1);
        CodeTool.TreeNode treeNode2 = new CodeTool.TreeNode(2);
        CodeTool.TreeNode treeNode3 = new CodeTool.TreeNode(3);
        treeNode1.left = null;
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;

        List<Integer> integers = CodeTool.inorderTraversal(treeNode1);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }


    @Test
    public void Test95() {
        List<CodeTool.TreeNode> treeNodes = CodeTool.generateTrees(3);
        for (CodeTool.TreeNode treeNode : treeNodes) {
            List<Integer> list = CodeTool.preorderTraversal(treeNode);
            for (Integer integer : list) {
                System.out.print(integer+ " ");
            }
            System.out.println();
        }
    }

    @Test
    public void Test102() {
        CodeTool.TreeNode treeNode1 = new CodeTool.TreeNode(1);
        CodeTool.TreeNode treeNode2 = new CodeTool.TreeNode(2);
        CodeTool.TreeNode treeNode3 = new CodeTool.TreeNode(3);
        CodeTool.TreeNode treeNode4 = new CodeTool.TreeNode(6);
        CodeTool.TreeNode treeNode5 = new CodeTool.TreeNode(8);
        CodeTool.TreeNode treeNode6 = new CodeTool.TreeNode(3);
        CodeTool.TreeNode treeNode7 = new CodeTool.TreeNode(7);
        treeNode1.left = null;
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode7;

        /**
         *          1
         *        2   3
         *          8   7
         */
        System.out.println("==========================");
        List<List<Integer>> lists = CodeTool.levelOrder(treeNode1);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print("结 果   "+ integer);
            }
            System.out.println();
        }
    }
}
