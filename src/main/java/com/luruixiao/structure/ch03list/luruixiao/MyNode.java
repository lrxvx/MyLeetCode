package com.luruixiao.structure.ch03list.luruixiao;

public class MyNode {
	public long data;
	//下一个节点
	public MyNode next;
	
	public MyNode(long value){
		this.data=value;
	}
	public void disPlay(){
		System.out.println("data is "+data);
	}
}
