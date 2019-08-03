package com.luruixiao.structure.ch03list.luruixiao;

public class MyLinkList {
	
	private MyNode first;
	
	private MyNode last;
	public MyLinkList(){
		first = null;
		last = null;
	}
	
	public void insertFirst(long value){
		MyNode node = new MyNode(value);
		node.next = first;
		first = node;
	}
	
	public void insertIndex(long value,int index){
		MyNode node = new MyNode(value);
		int count = 1;
		MyNode current = first;
		MyNode preNode = first;
		while(count!=index&&index>=1){
			preNode = current;
			current = current.next;
			count++;
		}
		if(current==first){
			node.next = first;
			first = node;
		}else{
			preNode.next = node;
			node.next = current;
		}
	}
	

	
	public MyNode deleteFirst(){
		MyNode node = first;
		first = first.next;
		return node;
	}
	
	public void disPlay(){
		MyNode current = first;
		while(current!=null){
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	public MyNode find(long value){
		MyNode current = first;
		while(current!=null){
			if(current.data==value){
				return current;
			}
			current = current.next;
		}
		return null;
	}
	
	public MyNode delete(long value){
		MyNode current = first;
		MyNode preNode = first;
		while(current!=null){
			if(current.data==value){
				if(current==first){
					first = first.next;
				}else{
					preNode.next = current.next;
				}
				return current;
			}
			preNode = current;
			current = current.next;
		}
		return null;
	}
}
