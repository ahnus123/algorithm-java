package softeer;

import java.util.Scanner;

public class softeer_581_DeliveryMasterGwangwoo {
	public static int N, M, K = 0;
	public static int minWeight;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// input
		N = sc.nextInt();		// 레일 개수
		M = sc.nextInt();		// 바구니 무게
		K = sc.nextInt();		// 일 시행 횟수
		int[] rails = new int[N];
		for (int i = 0; i < N; i++) {
			rails[i] = sc.nextInt();
		}
		minWeight = Integer.MAX_VALUE;
		
		permutation(rails, N, N, 0);
		
		System.out.println(minWeight);
	}
	
	// 택배 레일 전용 무게의 순열 구하기
	public static void permutation(int[] arr, int n, int r, int depth) {
		if (depth == r) {
//			for (int i = 0; i < arr.length; i++) {		// 순열 결과 출력
//				System.out.print(arr[i] + "  ");
//			}System.out.println();

			int idx = 0;
			int total = 0;
			for (int i = 0; i < K; i++) {	// K번 일하기
				int sum = 0;
				while (sum <= M) {			// 택배 바구니 무게를 넘는지 체크
					sum += arr[idx];
					idx = (idx+1) % arr.length;
					
					if (sum + arr[idx] > M) {
						break;
					}
				}
				total += sum;
			}
			
			minWeight = Math.min(minWeight, total);		// K번 일할 때, 최소한의 무게 구하기
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
}

/*
(Input)
5 20 4
5 8 10 19 7
(Outputs)
54

(Input)
9 25 50
1 21 2 22 3 23 4 24 10
(Outputs)
772
*/
