package com.luruixiao.structure.ch03list.luruixiao;


public class LinkDome {
	public static void main(String[] args) {
		MyLinkList linkList = new MyLinkList();
		linkList.insertFirst(34);
		linkList.insertFirst(23);
		
		linkList.insertFirst(0);
		linkList.insertFirst(-1);
		linkList.insertFirst(12);
		
		linkList.disPlay();
//		
		linkList.deleteFirst();
		System.out.println("=============");
		linkList.disPlay();
//		
		System.out.println("=========");
		MyNode node = linkList.find(23);
		node.disPlay();

//		MyNode node1 = linkList.delete(0);
//		node1.disPlay();
		System.out.println("===============");
//		linkList.disPlay();
		
		linkList.insertIndex(200, 3);
		linkList.disPlay();
	}
}
