package programmers;

import java.util.Arrays;

public class programmers_17685_AutoComplete {
	public static void main(String[] args) {
		String[] str1 = {"go","gone","guild"};
		solution(str1);
		//(output) 7
		
		String[] str2 = {"abc","def","ghi","jklm"};
		solution(str2);
		//(output) 4
		
		String[] str3 = {"word","war","warrior","world"};
		solution(str3);
		//(output) 15
	}
	
	public static int compareStr(String str1, String str2) {
		int minLength;
		int same = 0;
		if(str1.length() < str2.length()) 
			minLength = str1.length();
		else
			minLength = str2.length();
		
		for(int i=0;i<minLength;i++) {
			if(str1.charAt(i) == str2.charAt(i))
				same++;
			else
				break;
		}
		
		return same + 1;
	}
	
	public static int solution(String[] words) {
		int answer = 0;
		
		Arrays.sort(words);
		
		int first = compareStr(words[0], words[1]);
		if(first > words[0].length())
			first = words[0].length();
		answer += first;
		
		for(int i=1;i<words.length-1;i++) {
			int before = compareStr(words[i-1], words[i]);
			int after = compareStr(words[i], words[i+1]);
			
			if(before > words[i].length())
				before = words[i].length();
			if(after > words[i].length())
				after = words[i].length();
			
			if(before < after) {			//max값 더하기
				answer += after;
			} else {
				answer += before;
			}
		}
		
		int end = compareStr(words[words.length - 2], words[words.length - 1]);
		if(end > words[words.length - 1].length())
			end = words[words.length - 1].length();
		answer += end;
	
		System.out.println("Answer : " + answer);
		return answer;
	}
}
