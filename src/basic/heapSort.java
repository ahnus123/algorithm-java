package basic;

public class heapSort {

	public static void main(String[] args) {
		int[] arr = {5, 2, 12, 8, 15, 1, 4};
		
		heapSort(arr);
		
		for (int now : arr) {
			System.out.println(now);
		}
	}
	
	public static void heapify(int[] arr, int n, int i) {	// 2. Build-Max-Heap : 최대 힙(Heap) 구성
		int p = i;
		int left = i * 2 + 1;	// 왼쪽 자식 노드
		int right = i * 2 + 2;	// 오른쪽 자식 노드
		
		if (left < n && arr[p] < arr[left]) {
			p = left;
		}
		
		if (right < n && arr[p] < arr[right]) {
			p = right;
		}
		
		if (i != p) {		// 부모노드 < 자식노드
			swap(arr, p, i);
			heapify(arr, n, p);
		}
	}

	public static void heapSort(int[] arr) {
		int n = arr.length;
		
		for (int i = n / 2 - 1; i >= 0; i--) {		// 1. Max-Heapify : 힙 구성
			heapify(arr, n, i);
		}
		
		for (int i = n - 1; i > 0; i--) {		// 3. Heap-Sort : 루트의 값을 마지막 요소와 바꾼 후, 힙 사이즈를 하나 줄임
			swap(arr, 0, i);
			heapify(arr, i, 0);
		}
	}
	
	public static void swap(int[] arr, int n1, int n2) {
		int temp = arr[n1];
		arr[n1] = arr[n2];
		arr[n2] = temp;
	}
}
