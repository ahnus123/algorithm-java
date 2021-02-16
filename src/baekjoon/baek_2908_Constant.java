package baekjoon;

import java.util.*;

public class baek_2908_Constant {
	public static void main(String[] args) {
		int[] num = new int[2];
		int[] newNum = new int[2];
		
		Scanner sc = new Scanner(System.in);	//input
		for(int i=0;i<num.length;i++) {
			num[i] = sc.nextInt();
		}
		
		for(int i=0;i<num.length;i++) {			//숫자 2개만큼
			for(int j=0;j<3;j++) {				//3자리만큼
				int temp = num[i] % 10;			//마지막 숫자
				num[i] /= 10;
				newNum[i] += temp * Math.pow(10, (2 - j));		//마지막 숫자 맨 앞으로
			}
		}
		
		if(newNum[0] < newNum[1])			//두 숫자 비교 후 정답 출력
			System.out.println(newNum[1]);
		else
			System.out.println(newNum[0]);
		
	}
}

/*
(input)
734 893

(output)
437
*/