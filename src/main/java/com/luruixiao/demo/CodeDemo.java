package com.luruixiao.demo;

import com.luruixiao.code.CodeTool;
import org.junit.Test;

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
}
