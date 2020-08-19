package programmers;

import java.util.*;

public class programmers_12981_EnglishWordChain {

	public static void main(String[] args) {
		String[] words1= {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		solution(3, words1);
		//3, 3
		
		String[] words2= {"hello", "observe", "effect", "take", "either", "recognize", "encourage"
						, "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
		solution(5, words2);
		//0, 0
		
		String[] words3= {"hello", "one", "even", "never", "now", "world", "draw"};
		solution(2, words3);
		//1, 3
		
	}
	
	static public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        //String[][] ans = new String[n][words.length/n+1];
        int cnt = 1;
        ArrayList<String> spoken = new ArrayList<String>();
        //Set<String> spoken = new HashSet<String>();
        
        for(int i=0;i<words.length-1;i++) {
        	if(spoken.contains(words[i])) {		//단어 중복 체크
        		answer[0] = cnt%n == 0 ? n : cnt%n;
        		answer[1] = (cnt+n-1)/n;
                //System.out.println(i + "("+cnt+") : " + words[i] + ", " + words[i+1]);
        		break;
        	} else if(i == words.length-2 && spoken.contains(words[i+1])) {		//마지막 단어 중복 체크
        		cnt++;
        		answer[0] = cnt%n == 0 ? n : cnt%n;
        		answer[1] = (cnt+n-1)/n;
                //System.out.println(i + "("+cnt+") : " + words[i] + ", " + words[i+1]);
        		break;
        	} else if(words[i].charAt(words[i].length()-1) 
        				!= words[i+1].charAt(0)) {		//끝말잇기 성공 체크
        		cnt++;
        		answer[0] = cnt%n == 0 ? n : cnt%n;
        		answer[1] = (cnt+n-1)/n;
                //System.out.println(i + "("+cnt+") : " + words[i] + ", " + words[i+1]);
        		break;
        	} else {		//통과
        		cnt++;
        		spoken.add(words[i]);
        	}
        }
        
        if(cnt == words.length+1) {		//탈락자 없음
        	answer[0] = 0;
        	answer[1] = 0;
        }

        System.out.println(answer[0] + ", " + answer[1]);
        return answer;
    }

}
