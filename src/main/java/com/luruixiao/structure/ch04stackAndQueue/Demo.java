package com.luruixiao.structure.ch04stackAndQueue;

public class Demo {
	public static void main(String[] args) {
		MyStack ms = new MyStack(5);
		ms.push(1);
		ms.push(2);
		ms.push(3);
		ms.push(4);
		ms.push(5);
		MyStack ms2 = new MyStack(5);
		relese(ms,ms2);
		for (int i = 0; i < 5; i++) {
			System.out.println(ms2.pop());
		}
		
	}
	public static void relese(MyStack m1,MyStack m2){
		if(!m1.isEmpty()){
			long n = m1.pop();
			m2.push((int)n);
			relese(m1,m2);
		}
	}
}
