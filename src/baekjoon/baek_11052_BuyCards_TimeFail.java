package baekjoon;

import java.util.*;

public class baek_11052_BuyCards_TimeFail {
	public static int MAX_TEMP = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = 0;
		int[] prices = new int[n];
		int[] maxPrice = new int[n+1];
		
		for (int i = 0; i < n; i++) {
			prices[i] = sc.nextInt();
		}
		
		for (int i = 1; i <= n; i++) {		// 1~n까지 각각의 최대 금액 찾기(dp)
			maxPrice[i] = prices[i-1];	// 카드 i개의 금액
			int findMax = findMaximum(maxPrice, i);	// dp로 최대 금액 찾기
			
			if (findMax > maxPrice[i]) {	// 카드 i개 금액 vs dp로 찾은 최대 금액 중 최대값으로 업데이트
				maxPrice[i] = findMax;
			}
		}
		
		for (int i = 1; i <= n; i++) {
			answer = Math.max(answer, maxPrice[i]);
			//System.out.print(maxPrices[i] + "\t");	// maxPrices 출력
		}//System.out.println();
		
		System.out.println(answer);
	}

	public static int findMaximum(int[] maxPrices, int num) {	// dp로 최대 금액 찾기
		MAX_TEMP = -1;	// maxPrices[num]의 최대값
		
		for (int i = 1; i <= num; i++) {
			int[] arr = new int[num];
			DuplicateCombination(maxPrices, arr, num, i, 0, 1);	// nC1 ~ nCn 중복조합
		}
		
		return MAX_TEMP;
	}
	
	// 카드 개수 중복 조합
	public static void DuplicateCombination(int[] maxPrices, int[] arr, int n, int r, int idx, int target) {
		if (r == 0) {
			int sum = 0;
			int sumPrice = 0;
			for (int i = 0; i < arr.length; i++) {	// 카드팩 조합별 금액 합산
				sum += arr[i];
				sumPrice += maxPrices[arr[i]];
			}
			
			if (sum == n) {
				if (sumPrice > MAX_TEMP) {		// maxPrices[i]의 카드 최대 금액 업데이트
					MAX_TEMP = sumPrice;
				}

//				for(int i=0;i<arr.length;i++)	// 카드 개수 조합
//					System.out.print(arr[i] + "\t");
//				System.out.println("\nsum : " + sumPrice);
			}
			
			return;
		}
		
		if (target > n) {
			return;
		}
		
		arr[idx] = target;
		DuplicateCombination(maxPrices, arr, n, r-1, idx+1, target);	// 선택
		DuplicateCombination(maxPrices, arr, n, r, idx, target+1);		// 선택 X
	}
}


/*
(input)
4
1 5 6 7
(output)
10

(input)
5
10 9 8 7 6
(output)
50

(input)
10
1 1 2 3 5 8 13 21 34 55
(output)
55

(input)
10
5 10 11 12 13 30 35 40 45 47
(output)
50

(input)
4
5 2 8 10
(output)
20

(input)
4
3 5 15 16
(output)
18
*/
