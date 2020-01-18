package baekjun;

import java.util.*;

public class baek_2455_IntelligentTrain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0, max = -1;
		int train[][] = new int[4][2];
		for(int i=0;i<train.length;i++) {		//input
			for(int j=0;j<train[i].length;j++) {
				train[i][j] = sc.nextInt();

				if(j == 0)				//내리는 사람
					train[i][j] *= -1;
				
				sum += train[i][j];		//기차 안에 있는 인구 수
				if(sum > max)			//최대값 갱신
					max = sum;
			}
		}
		
		System.out.println(max);
	}
}


/*
(input)
0 32
3 13
28 25
39 0
(output)
42
*/