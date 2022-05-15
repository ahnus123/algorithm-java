package basic;

import java.util.Arrays;

public class mergeSort {

	public static void main(String[] args) {
		int[] arr = {52, 3, 24, 12, 10, 8, 33};
		
		mergeSort(arr, 0, arr.length - 1);
		
		for (int now : arr) {
			System.out.println(now);
		}
	}

	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			
			mergeSort(arr, left, mid);			// 1. 분할(Divide)
			mergeSort(arr, mid+1, right);
			merge(arr, left, mid, right);		// 3. 합병(Merge)
		}
	}
	
	public static void merge(int[] arr, int left, int mid, int right) {
		int [] L = Arrays.copyOfRange(arr,  left, mid+1);
		int [] R = Arrays.copyOfRange(arr, mid+1, right+1);
		
		int i = 0;
		int j = 0;
		int k = left;
		int lSize = L.length;
		int rSize = R.length;
		
		while (i < lSize && j < rSize) {	// 2. 정복(Conquer)
			if (L[i] <= R[j]) {
				arr[k] = L[i++];
			} else {
				arr[k] = R[j++];
			}
			k++;
		}
		
		while (i < lSize) {
			arr[k++] = L[i++];
		}
		
		while (j < rSize) {
			arr[k++] = R[j++];
		}
	}
}
