package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class programmers_64062_SteppingStone {

	public static void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		solution(stones, 3);
		//(Outputs) 3
	}

    public static int solution(int[] stones, int k) {
        int answer = 0;
        int minCross = Integer.MAX_VALUE;
        int maxCross = -1;
        
        for(int i=0;i<stones.length;i++) {	// 디딤돌 숫자 최소값,최대값
        	if(minCross > stones[i])
        		minCross = stones[i];
        	if(maxCross < stones[i])
        		maxCross = stones[i];
        }
        
        while(minCross <= maxCross) {		// 이분탐색
            int mid = (minCross + maxCross) / 2;
            
        	if(canCross(stones, k, mid))	// mid명이 징검다리를 건널 수 있는지
        		minCross = mid+1;		// (최소 ~ mid)명 징검다리 건너기 가능
        	else
        		maxCross = mid;			// (mid ~ 최대)명 징검다리 건너기 가능
        	
        	if(minCross == maxCross) {
        		answer = minCross;
        		break;
        	}
        	//System.out.println(minCross + " | " + maxCross);
        }
        
        answer = minCross;
        
        System.out.println(answer);
        return answer;
    }
    
    public static boolean canCross(int[] stones, int k, int count) {
    	int jump = 0;
    	
    	for(int i=0;i<stones.length;i++) {
    		if(stones[i] - count <= 0)
    			jump++;
    		else
    			jump = 0;
    		
    		if(jump == k)
    			return false;
    	}
    	
    	return true;
    }
}
