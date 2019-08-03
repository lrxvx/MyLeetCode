package com.luruixiao.structure.ch01array;

public class MyOrderArray {
	private long[] arr;
	//表示有效数据的长度
	private int elements;
	
	public MyOrderArray() {
		arr = new long[50];
	}
	
	public MyOrderArray(int maxsize) {
		arr = new long[maxsize];
	}
	
	/**
	 * 添加数据
	 */
	public void insert(long value) {
		int i;
		/**
		 * 为了是数据添加时就是有序的，找到第一个比value大的位置
		 */
		for(i = 0; i < elements; i++) {
			if(arr[i] > value) {
				break;
			}
		}
		/**
		 * 从最后到第一个对value大的位置，全部往后走一位 i也就是value的位置也往后走
		 * 最后添加
		 */
		for(int j = elements; j > i; j--) {
			arr[j] = arr[j - 1];
		}
		arr[i] = value;
		elements++;
	}
	
	/**
	 * 显示数据
	 */
	public void display() {
		System.out.print("[");
		for(int i = 0; i < elements; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("]");
	}
	
	/**
	 * 查找数据
	 */
	public int search(long value) {
		int i;
		for(i = 0; i < elements; i++) {
			if(value == arr[i]) {
				break;
			}
		}
		
		if(i == elements) {
			return -1;
		} else {
			return i;
		}
		
	}
	
	/**
	 * 二分法查找数据
	 */
	public int binarySearch(long value) {
		int middle = 0;
		int low = 0;
		int pow = elements;
		
		while(true) {
			middle = (pow + low) / 2;
			if(arr[middle] == value) {
				return middle;
			} else if(low > pow) {
				return -1;
			} else {
				if(arr[middle] > value) {
					pow = middle - 1;
				} else {
					low = middle + 1;
				}
			}
		}
	}
	
	
	/**
	 * 查找数据，根据索引来查
	 */
	public long get(int index) {
		if(index >= elements || index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			return arr[index];
		}
	}
	
	/**
	 * 删除数据
	 */
	public void delete(int index) {
		if(index >= elements || index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			for(int i = index; i < elements; i++) {
				arr[index] = arr[index + 1];
			}
			elements--;
		}
	}
	
	/**
	 * 更新数据
	 */
	public void change(int index, int newvalue) {
		if(index >= elements || index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			arr[index] = newvalue;
		}
	}
	
	public long twoSearch(long value){
		int minIndex = 0;
		int maxIndex = elements;
		int middleIndex = (maxIndex+minIndex)/2;
		while(true){
			if(arr[middleIndex]==value){
				System.out.println("index is "+middleIndex);
				return middleIndex;
			}else if(arr[middleIndex]>value){
				maxIndex = middleIndex-1;
				middleIndex = (maxIndex+minIndex)/2;
			}else{
				minIndex = middleIndex+1;
				middleIndex = (maxIndex+minIndex)/2;
			}
			if(maxIndex<minIndex){
				System.out.println("没有"+value+"该值");
				return -1;
			}
		}
	}
}
