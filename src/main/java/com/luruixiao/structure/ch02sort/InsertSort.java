package com.luruixiao.structure.ch02sort;

public class InsertSort {
	
	public static void sort(long[] arr) {
		long tmp = 0;
		
		for(int i = 1; i < arr.length; i++) {
			tmp = arr[i];
			int j = i;
			while(j > 0 && arr[j] >= tmp) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = tmp;
		}
	}
	/*
	 * 插入排序，分为两个部分，有序部分和无序部分
	 * 思想是，从无序部分中找一个往有序部分找到对应的位置进行插入，最终形成有序数组
	 */
	public static void sort2(long[] arr){
		long temp = 0;
		for (int i = 1; i < arr.length; i++) {
			temp = arr[i];//要插入的数
			int j = i;//要插入排序的位置
			while(j > 0&&temp < arr[j-1]){//要插入排序的位置的数比前面的数小
				arr[j] = arr[j-1];//j-1往后走一位
				j--;
			}
			//找到符合的位置
			arr[j]=temp;
		}
		
	}
}
