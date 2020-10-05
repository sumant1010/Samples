package com.test;

/*
 * PROBLEM STATEMENT
 * 

Given an array of integers and a number k, where 1 <= k <= length of the array, 
compute the maximum values of each sub-array of length k.

For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

10 = max(10, 5, 2)
7 = max(5, 2, 7)
8 = max(2, 7, 8)
8 = max(7, 8, 7)

Do this in O(n) time and O(k) space. 
You can modify the input array in-place and you do not need to store the results. 
You can simply print them out as you compute them.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class MaxFromSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getAllMaxFromArray(new int[] {10, 5, 2, 7, 8, 7},3);

	}
	public static void getAllMaxFromArray(int[] arr,int k) {
		if(k==0 || k>arr.length) {
			System.out.print("Invalid K");
		}
		int[] maxArray = new int[arr.length];
		int[] supplyArray = new int[k];
		ArrayList<Integer> finalArr  = new ArrayList<Integer>();
		// O(n) below
		for(int i=0;i<arr.length-(k-1);i++) {
			// O(k) below
			for(int j=0;j<k;j++) {
				try {
				supplyArray[j]=arr[j+i];
				}
				catch(Exception ex) 
				{
					System.out.print(ex.getMessage() + i + " " + j);
				}
			}
			// Not sure about this, but probably O(n)
			Arrays.sort(supplyArray);
			
			int result = getMax(supplyArray);
			finalArr.add(result);
		}
		// Again O(n)
		System.out.print(finalArr);
	}
	public static int getMax(int[] suppArr) {
		return suppArr[suppArr.length-1];
	}

}
