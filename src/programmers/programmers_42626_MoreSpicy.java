package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class programmers_42626_MoreSpicy {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		solution(scoville, 7);
		//(Outputs) 2
	}

    public static int solution(int[] scoville, int K) {	// PriorityQueue 사용
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<scoville.length;i++)
        	pq.add(scoville[i]);
        
        while(true) {
        	if(pq.size() < 2) {
        		if(pq.poll() < K)
        			answer = -1;
        		
        		break;
        	}
        	
        	int min1 = pq.poll();	// 스코빌 지수 계산
        	int min2 = pq.poll();
        	int scov = min1 + 2 * min2;
        	
        	if(min1 >= K)
        		break;
        	
        	pq.add(scov);
        	answer++;
        }
        
        System.out.println(answer);
        return answer;
    }
}
