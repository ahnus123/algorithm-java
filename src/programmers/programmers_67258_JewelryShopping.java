package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class programmers_67258_JewelryShopping {

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
    	Set<String> allGems = new HashSet<>();
        Queue<String> gq = new LinkedList<>();
        Map<String, Integer> gmap = new HashMap<>();
        
        for(int i=0;i<gems.length;i++)		// 모든 보석 종류
        	allGems.add(gems[i]);
        
        int minLength = gems.length + 1;
        int start = 0;
        
        for(int i=0;i<gems.length;i++) {
        	gq.add(gems[i]);
        	
        	if(gmap.containsKey(gems[i]))	// map에 보석 개수 + 1
        		gmap.put(gems[i], gmap.get(gems[i])+1);
        	else
        		gmap.put(gems[i], 1);
        	
        	while(true) {
        		String gemFirst = gq.peek();
        		
        		if(gmap.get(gemFirst) > 1) {	// 맨 앞 보석이 2개 이상이면 1개 빼고 start + 1
        			gq.poll();
        			start++;
        			gmap.put(gemFirst, gmap.get(gemFirst)-1);
        		} else {
        			break;
        		}
        	}
        	
        	// map 크기 == 모든 보석 종류 수 && 최소길이 갱신하면
        	if(gmap.size() == allGems.size() && minLength > gq.size()) {
        		minLength = gq.size();
        		answer[0] = start + 1;
        	}
        }

        answer[1] = answer[0] + minLength - 1;
        System.out.println(answer[0] + ", " + answer[1]);
        
        return answer;
    }
}
