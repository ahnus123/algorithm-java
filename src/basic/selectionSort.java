package basic;

public class selectionSort {

	public static void main(String[] args) {
		int[] arr = {23, 5, 12, 7, 11, 3};
		
		selectionSort(arr);
		
		for (int now : arr) {
			System.out.println(now);
		}
	}

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int idxMin = 1;
			for (int j = i + 1; j < arr.length; j++) {	// 1. 주어진 배열 중 최소값 찾기
				if (arr[j] < arr[idxMin]) {
					idxMin = j;
				}
			}

			int temp = arr[idxMin];		// 2. 그 값을 맨 앞에 위치한 값과 교체 
			arr[idxMin] = arr[i];
			arr[i] = temp;
		}
	}
}
