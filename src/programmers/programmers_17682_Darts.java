package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class programmers_17682_Darts {

	public static void main(String[] args) {
		String str1 = "1S2D*3T";
		solution(str1);
		// (output) 37
		
		String str2 = "1D2S#10S";
		solution(str2);
		// (output) 9
		
		String str3 = "1D2S0T";
		solution(str3);
		// (output) 3
		
		String str4 = "1S*2T*3S";
		solution(str4);
		// (output) 23
		
		String str5 = "1D#2S*3S";
		solution(str5);
		// (output) 5
		
		String str6 = "1T2D3D#";
		solution(str6);
		// (output) -4
		
		String str7 = "1D2S3T*";
		solution(str7);
		// (output) 59

	}

	public static int solution(String dartResult) {
		int answer = 0;
		int numCount = -1;
		int[] num = new int[dartResult.length()];
		char[] arrChar = dartResult.toCharArray();

		int idx = 0;
		int now = 0;
		for(int i=0;i<arrChar.length;i++) {
			if(arrChar[i] >= '0' && arrChar[i] <= '9') {			//숫자
				if(arrChar[i] == '1' && arrChar[i+1] == '0') {		//10일 때
					now = 10;
					i++;
				} else {
					now = arrChar[i] - '0';
				}
				
				num[idx] = now;
				idx++;
			} else if(arrChar[i] == 'D') {			//double
				num[idx-1] *= num[idx-1];
			} else if(arrChar[i] == 'T') {			//triple
				num[idx-1] *= num[idx-1] * num[idx-1];
			} else if(arrChar[i] == '*') {			//이전 * 2 & 지금 * 2
				if(idx > 1)
					num[idx-2] *= 2;
				num[idx-1] *= 2;
			} else if(arrChar[i] == '#') {			//지금 * -1
				num[idx-1] *= -1;
			}
		}
		
		for(int i=0;i<idx;i++)
			answer += num[i];

		System.out.println("Answer : " + answer);

		return answer;
	}
}
