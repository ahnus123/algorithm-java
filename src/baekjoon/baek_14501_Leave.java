package baekjoon;

import java.util.*;

public class baek_14501_Leave {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int input[][] = new int [n][2];
		for(int i=0;i<n;i++) {
			input[i][0] = sc.nextInt();
			input[i][1] = sc.nextInt();
		}
		
		int answer = checkConsulting(input, 0, 0);
		System.out.println(answer);
	}

	public static int checkConsulting(int input[][], int today, int sumPrice) {
		int res1 = 0, res2 = 0;
		
		//System.out.println(today + " " + sumPrice);
		if(today >= input.length) {					//퇴사 날짜 지남
			return sumPrice;
		} else if(today == input.length - 1) {		//퇴사하기 전날
			if(input[today][0] == 1)				//1일짜리 상담
				return sumPrice + input[today][1];
			else if(input[today][0] > 1)			//1일 이상 상담
				return sumPrice;
		}
		
		
		res1 = checkConsulting(input, today + 1, sumPrice);		//오늘 상담 (X)
		if(today + input[today][0] <= input.length) {
			sumPrice += input[today][1];
			res2 = checkConsulting(input, today + input[today][0], sumPrice);	//오늘 상담 (O)
		}
			
		if(res1 > res2)		//최대 이익 값 갱신
			return res1;
		else
			return res2;
	}
}