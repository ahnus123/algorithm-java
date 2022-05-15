package basic;

public class insertionSort {

	public static void main(String[] args) {
		int[] arr = {3, 57, 24, 6, 13, 11};
		
		insertionSort(arr);
		
		for (int now : arr) {
			System.out.println(now);
		}
	}

	public static void insertionSort(int[] arr) {
		for (int idx = 1; idx < arr.length; idx++) {
			int temp = arr[idx];	// 1. 정렬은 2번째 위치(index)의 값을 temp에 저장함
			int prev = idx - 1;
			
			while (prev >= 0 && arr[prev] > temp) {		// 2. temp와 이전에 있는 원소들을 비교하며 삽입해 나감
				arr[prev+1] = arr[prev];
				prev--;
			}
			
			arr[prev+1] = temp;		// 3. 1번으로 돌아가 다음 위치(index)의 값을 temp에 저장하고, 반복함
		}
	}
}
