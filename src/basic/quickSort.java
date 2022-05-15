package basic;

public class quickSort {

	public static void main(String[] args) {
		int[] arr = {5, 11, 13, 45, 34, 8, 3, 19};
		
		quickSort(arr, 0, arr.length-1);
		
		for(int now : arr) {
			System.out.println(now);
		}
	}

	public static void quickSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		
		int pivot = partition(arr, left, right);	// Divide
		
		quickSort(arr, left, pivot-1);		// Conquer
		quickSort(arr, pivot+1, right);		// Conquer
	}
	
	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[left];		// pivot -> 가장 왼쪽 값
		int i = left;
		int j = right;
		
		while (i < j) {
			while (pivot < arr[j]) {
				j--;
			}
			
			while (i < j && pivot >= arr[i]) {
				i++;
			}
			
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		
		arr[left] = arr[i];
		arr[i] = pivot;
		
		return i;
	}
}
