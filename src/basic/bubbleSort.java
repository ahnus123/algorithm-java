package basic;

public class bubbleSort {

	public static void main(String[] args) {
		int[] arr = {5, 25, 11, 9, 6, 12, 46, 2};
		
		bubbleSort(arr);
		
		for (int now : arr) {
			System.out.println(now);
		}
	}

	public static void bubbleSort(int[] arr) {
		// 1. 1회전에 1번째 원소와 2번째 원소를, 2번째 원소와 3번째 원소를,  ... 이런 식으로 
		// (마지막-1)번째 원소와 마지막 원소를 비교하여 조건에 맞지 않으면 서로 교환함
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}
