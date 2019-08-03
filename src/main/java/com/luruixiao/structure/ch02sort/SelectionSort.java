package com.luruixiao.structure.ch02sort;

public class SelectionSort {
	
	public static void sort(long[] arr) {
		int k = 0;
		long tmp = 0;
		for(int i = 0; i < arr.length - 1; i++) {
			k = i;
			for(int j = i; j < arr.length; j++) {
				if(arr[j] < arr[k]) {
					k = j;
				}
			}
			tmp = arr[i];
			arr[i] = arr[k];
			arr[k] = tmp;
		}
	}
	
	public static void sort2(long[] arr){
		int k = 0;
		long temp = 0;
		for (int i = 0; i < arr.length-1; i++) {
			k = i;//目前最小的值所在的位置
			for (int j = i; j < arr.length; j++) {
				if(arr[j] < arr[k]){
					k = j;
				}
			}
			//一次循环可以找到当前在i之后的最小或者最大的值
			temp = arr[k];//最小值的位置
			arr[k] = arr[i];
			arr[i] = temp;//在i位置存放最小值
		}
		
	}
}
