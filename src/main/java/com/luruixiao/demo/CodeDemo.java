package com.luruixiao.demo;

import com.luruixiao.code.CodeTool;

/**
 */
public class CodeDemo {

    public static void main(String[] args) {
        int[] arr1 = {9};
        int[] arr2 = {9,9,9,9,9,9,9,9,9,1};
        CodeTool.ListNode node1 = fillNode(arr1);
        CodeTool.ListNode node2 =  fillNode(arr2);
//        CodeTool.ListNode node1 = new CodeTool.ListNode(2);
//        node1.next = new CodeTool.ListNode(4);
//        node1.next.next = new CodeTool.ListNode(3);
//
//        CodeTool.ListNode node2 = new CodeTool.ListNode(5);
//        node2.next = new CodeTool.ListNode(6);
//        node2.next.next = new CodeTool.ListNode(4);

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
    private static CodeTool.ListNode fillNode(int[] arr) {
        CodeTool.ListNode listNode = null;
        for (int i : arr) {
            CodeTool.ListNode node = new CodeTool.ListNode(i);
            node.next = listNode;
            listNode = node;
        }
        return listNode;
    }
}
