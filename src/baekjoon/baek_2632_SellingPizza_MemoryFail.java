package baekjoon;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class baek_2632_SellingPizza_MemoryFail {
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
		for(int i=0;i<m;i++) {
			A[i] = sc.nextInt();
			sizeA += A[i];
		}
		for(int i=0;i<n;i++) {
			B[i] = sc.nextInt();
			sizeB += B[i];
		}
		int[] subSumA = new int[sizeA+1];
		int[] subSumB = new int[sizeB+1];
		
		getSubSum(A, subSumA);
		getSubSum(B, subSumB);

//		for(int i=1;i<subSumA.length;i++)
//			System.out.print(subSumA[i] + " \t");
//		System.out.println();
		
		for(int i=0;i<=order;i++) {
			if(i >= subSumA.length) {
				if(order < subSumB.length)
					answer += subSumB[order];
				continue;
			} else if(order-i >= subSumB.length){
				if(order < subSumA.length)
					answer += subSumA[order];
				continue;
			} else {
				if(subSumA[i] > 0 && subSumB[order-i] > 0)
					answer += subSumA[i] * subSumB[order-i];
				else if(i == 0 || i == order)
					answer += subSumA[i] + subSumB[order-i];
			}
			//System.out.println(i + " : " + subSumA[i] + " / " +(order-i) + " : " + subSumB[order-i]);
		}
		
		System.out.println(answer);
	}
	
	public static void getSubSum(int[] pizza, int[] subSum) {
		HashSet<String> slices = new HashSet<>();
		
		for(int i=0;i<pizza.length;i++) {	// 시작 지점
			for(int j=1;j<=pizza.length;j++) {	// 피자 조각 개수
				String arr = "";
				for(int k=i;k<i+j;k++) {
					arr += Integer.toString(pizza[k % pizza.length]);
				}
				slices.add(arr);
			}
		}
		
		for(String slice : slices) {
			int sum = 0;
			for(int i=0;i<slice.length();i++) {
				sum += Integer.parseInt(slice.charAt(i)+"");
			}
			subSum[sum]++;
		}
	}
}
