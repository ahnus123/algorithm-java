package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class programmers_67258_JewelryShopping_EffFail {

	public static void main(String[] args) {
		String[] gems1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		solution(gems1);
		//(Outputs) {3, 7}
		
		String[] gems2 = {"AA", "AB", "AC", "AA", "AC"};
		solution(gems2);
		//(Outputs) {1, 3}
		
		String[] gems3 = {"XYZ", "XYZ", "XYZ"};
		solution(gems3);
		//(Outputs) {1, 1}
		
		String[] gems4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
		solution(gems4);
		//(Outputs) {1, 5}
	}


    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> gemsNames = new HashSet<>();
        
        for(int i=0;i<gems.length;i++)		// 모든 보석 종류
        	gemsNames.add(gems[i]);
        
        int[] allGems = new int[gems.length];	// allGems[i] = j (i:시작지점, j:끝지점)
        int minLength = gems.length + 1;
        int minStart = gems.length;
        
        for(int i=0;i<=gems.length-gemsNames.size();i++) {
        	Set<String> g = new HashSet<>();	// i번째부터 구입한 보석들
        	
        	for(int j=i;j<gems.length;j++) {
        		g.add(gems[j]);
        		
        		if(g.size() >= gemsNames.size()) {	// 모든 종류의 보석 구입 완료
        			allGems[i] = j;
        			
        			if((j - i + 1) < minLength) {	// 가장 짧은 구간 업데이트
        				minStart = i;
        				minLength = j - i + 1;
        			}
        			
        			break;
        		}
        	}
        }

        answer[0] = minStart + 1;
        answer[1] = allGems[minStart] + 1;
        System.out.println(answer[0] + ", " + answer[1]);
        
        return answer;
    }
}
