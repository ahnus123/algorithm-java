package baekjoon;

import java.util.Scanner;

public class baek_2632_SellingPizza1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	// input
		int order = sc.nextInt();
		int m = sc.nextInt();
		int n = sc.nextInt();
		int sizeA = 0;
		int sizeB = 0;
		int answer = 0;
		int[] A = new int[m];
		int[] B = new int[n];
		int[] subSumA = new int[order+1];
		int[] subSumB = new int[order+1];
		for (int i = 0; i < m; i++) {
			A[i] = sc.nextInt();
			sizeA += A[i];
		}
		for (int i = 0; i < n; i++) {
			B[i] = sc.nextInt();
			sizeB += B[i];
		}
		
		subSumA[0] = 1;
		subSumB[0] = 1;
		if (sizeA <= order) {
			subSumA[sizeA] = 1;
		}
		if (sizeB <= order) {
			subSumB[sizeB] = 1;
		}
		
		getSubSum(A, subSumA, order);
		getSubSum(B, subSumB, order);

		for (int i = 0; i <= order; i++) {
			if (i < subSumA.length && order-i < subSumB.length) {
				answer += subSumA[i] * subSumB[order-i];
			}
			//System.out.println(i + " : " + subSumA[i] + " / " +(order-i) + " : " + subSumB[order-i]);
		}
		
		System.out.println(answer);
	}
	
	public static void getSubSum(int[] pizza, int[] subSum, int order) {
		for (int i = 0; i < pizza.length; i++) {			// 시작 지점 : 첫번째~마지막
			int sum = 0;
			for (int j = 0; j < pizza.length - 1; j++) {	// 피자 조각 개수 : 1~(전체피자조각-1)
				sum += pizza[(i+j) % pizza.length];
				if(sum <= order) {
					subSum[sum]++;			// 부분합
				}
			}
		}
	}
}
