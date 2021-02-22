package etc;

public class combination {

	public static void main(String[] args) {
		int[] origin = {1, 3, 5, 7, 9};
		
		for (int i = 1; i < origin.length; i++) {
			int[] arr = new int[i];
			//combination(origin, arr, origin.length, i, 0, 0);	// 조합 : nCr
		}
		
		for (int i = 1; i < origin.length; i++) {
			int[] arr = new int[i];
			//recombination(origin, arr, origin.length, i, 0, 0);	// 중복조합 : nCr
		}
		
		for (int i = 1; i < origin.length; i++) {
			int[] arr = new int[i];
			//permutation(origin, origin.length, i, 0);			// 순열 : nPr
		}
		
		for (int i = 1; i < origin.length; i++) {
			int[] arr = new int[i];
			rePermutation(origin, arr, origin.length, i, 0);	// 중복 순열
		}
	}
	
	// 조합
	public static void combination(int[] origin, int[] arr, int n, int r, int target, int idx) {
		if (r == 0) {
			System.out.println("Combination -> " + n + "C" + r);
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + "\t");
			}System.out.println("\n");
			return;
		}
		
		if (n == target) {
			return;
		}
		
		arr[idx] = origin[target];
		combination(origin, arr, n, r-1, target+1, idx+1);
		combination(origin, arr, n, r, target+1, idx);
	}
	
	// 중복조합
	public static void recombination(int[] origin, int[] arr, int n, int r, int target, int idx) {
		if (r == 0) {
			System.out.println("Recombination -> " + n + "C" + r);
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + "\t");
			}System.out.println("\n");
			return;
		}
		
		if (n == target) {
			return;
		}
		
		arr[idx] = origin[target];
		combination(origin, arr, n, r-1, target, idx+1);
		combination(origin, arr, n, r, target+1, idx);
	}
	
	// 순열
	public static void permutation(int[] arr, int n, int r, int depth) {
		if (depth == r) {
			System.out.println("Permutation -> " + n + "P" + r);
			for (int i = 0; i < r; i++) {
				System.out.print(arr[i] + "\t");
			}System.out.println("\n");
			return;
		}
		
		for (int i = depth; i < n; i++) {
			swap(arr, depth, i);
			permutation(arr, n, r, depth+1);
			swap(arr, depth, i);
		}
	}
	
	public static void swap(int[] arr, int i, int depth) {
		int temp = arr[i];
		arr[i] = arr[depth];
		arr[depth] = temp;
	}
	
	// 중복 순열
	public static void rePermutation(int[] origin, int[] arr, int n, int r, int target) {
		if (target == r) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + "\t");
			}System.out.println();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			arr[target] = origin[i];
			rePermutation(origin, arr, n, r, target+1);
		}
	}
}
