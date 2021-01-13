package programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class programmers_43163_WordConversion {

	public static void main(String[] args) {
		String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};
		solution("hit", "cog", words1);
		//(Outputs) 4
		
		String[] words2 = {"hot", "dot", "dog", "lot", "log"};
		solution("hit", "cog", words2);
		//(Outputs) 0
	}

    public static int solution(String begin, String target, String[] words) {
    	int answer = 0;
        int[] conCount = new int[words.length];
        Queue<String[]> conWords = new LinkedList<>();
        
        String[] begins = {begin, "0"};
        conWords.add(begins);
        
        boolean isEnd = false;
        while(!conWords.isEmpty()) {
        	String[] now = conWords.poll();
        	
        	for(int i=0;i<words.length;i++) {
        		if(canConversion(words[i], now[0])) {	// 변환 가능한 단어 stack에 저장
        			System.out.println(now[0] + " >> " + words[i]);
        			
        			if(conCount[i] == 0) {		// 체크한적 없는 단어면
        				conCount[i] = Integer.parseInt(now[1]) + 1;
	        			if(words[i].equals(target)) {	// target으로 변환 완료
	        				answer = Integer.parseInt(now[1]) + 1;
	        				isEnd = true;

		        			System.out.println("=== " + words[i] + ", " + answer + " ===");
	        				break;
	        			} else {
		        			int count = Integer.parseInt(now[1]) + 1;
		        			String[] next = {words[i], String.valueOf(count)};
		        			conWords.add(next);
		        			System.out.println("--- " + words[i] + ", " + count + " ----");
	        			}
        			}
        		}
        	}
        	
        	if(conWords.isEmpty() && !isEnd) {	// target으로 변환 불가
        		answer = 0;
        		break;
        	}
        }
        
        System.out.println(answer);
        return answer;
    }
    
    public static boolean canConversion(String word1, String word2) {
    	int diff = 0;
		for(int i=0;i<word1.length();i++)
			if(word1.charAt(i) != word2.charAt(i))
				diff++;
		
		if(diff == 1)
			return true;
		else
			return false;
    }
}
