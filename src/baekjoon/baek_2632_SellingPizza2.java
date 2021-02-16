package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class baek_2632_SellingPizza2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	// input
		int order = sc.nextInt();
		int m = sc.nextInt();
		int n = sc.nextInt();
		int sizeA = 0;				// 피자A의 전체 크기
		int sizeB = 0;				// 피자B의 전체 크기
		int answer = 0;
		int[] A = new int[m];		// 피자A의 조각 배열
		int[] B = new int[n];		// 피자B의 조각 배열
		ArrayList<Integer> subSumA = new ArrayList<>();		// 피자A의 부분합 리스트
		ArrayList<Integer> subSumB = new ArrayList<>();		// 피자B의 부분합 리스트
		for (int i = 0; i < m; i++) {
			A[i] = sc.nextInt();
			sizeA += A[i];
		}
		for (int i = 0; i < n; i++) {
			B[i] = sc.nextInt();
			sizeB += B[i];
		}
		
		subSumA.add(0);			
		subSumB.add(0);			// 피자 조각 선택 X
		subSumA.add(sizeA);		
		subSumB.add(sizeB);		// 전체 피자 조각 선택
		
		getSubSum(A, subSumA, order);		// 1~(전체피자조각-1) 조각의 부분합
		getSubSum(B, subSumB, order);
		
		Collections.sort(subSumA);	// 부분합 정렬
		Collections.sort(subSumB);	
		//(참고) 역순정렬 : Collections.sort(subSumB, Comparator.reverseOrder());
		
		int a = 0;					// 피자A는 오름차순
		int b = subSumB.size()-1;	// 피자B는 내림차순
		while (a < subSumA.size() && b >= 0) {
			int sliceA = subSumA.get(a);
			int sliceB = subSumB.get(b);
			if (sliceA + sliceB == order) {		// 목표 크기를 찾으면
				int cntA = 0;
				int cntB = 0;
				
				while (a < subSumA.size()) {		// 피자A의 부분합 개수 카운트
					if (sliceA == subSumA.get(a)) {
						cntA++;
						a++;
					} else {
						break;
					}
				}
				while(b >= 0) {					// 피자B의 부분합 개수 카운트
					if (sliceB == subSumB.get(b)) {
						cntB++;
						b--;
					} else {
						break;
					}
				}
				answer += cntA * cntB;			// 가짓수 업데이트
			}
			
			if (sliceA + sliceB < order) {		// 피자A+피자B 부분합 < 목표값
				a++;
			}
			if (sliceA + sliceB > order) {		// 피자A+피자B 부분합 > 목표값
				b--;
			}
		}
		
		System.out.println(answer);
	}
	
	public static void getSubSum(int[] pizza, ArrayList<Integer> subSum, int order) {
		for (int i = 0; i < pizza.length; i++) {			// 시작 지점 : 첫번째~마지막
			int sum = 0;
			for (int j = 0; j < pizza.length - 1; j++) {	// 피자 조각 개수 : 1~(전체피자조각-1)
				sum += pizza[(i+j) % pizza.length];		// 부분합
				
				if (sum < order) {		// 주문한 값보다 작은 부분합만 추가
					subSum.add(sum);
				}
			}
		}
	}
}


/*
(Input)
7
5 3
2 2 1 7 2
6 8 3
(Outputs)
5

(Input)
4
1 3
1
1 1 1
(Outputs)
1

(Input)
6
3 3
1 1 1 1 1 1
(Outputs)
1
*/
