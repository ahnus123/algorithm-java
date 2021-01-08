package programmers;

import java.util.Arrays;

public class programmers_24348_Immigration {

	public static void main(String[] args) {
		int[] times = {7, 10};
		solution(6, times);
		//(Outputs) 28
	}

    public static long solution(int n, int[] times) {
        Arrays.sort(times);
    	
        long answer = Long.MAX_VALUE;
        long minTime = 0;
        long maxTime = times[times.length-1] * (long)n;
        // [주의] times[times.length-1] * n -> (int) * (int) 임
        
        while(minTime <= maxTime) {
            long mid = (minTime + maxTime) / 2;
        	long person = 0;
        	
        	for(int i=0;i<times.length;i++)	// 심사관 별 심사 가능한 사람 수
        		person += mid / times[i];
        	
        	// 이분 탐색
        	if(person < n)			// n명 이상 심사 불가능한 시간대
        		minTime = mid+1;
        	else {					// n명 이상 심사 가능한 시간대
        		if(answer >= mid)	// answer 업데이트
        			answer = mid;
        		maxTime = mid-1;
        	}
        }
        
        System.out.println(answer);
        return answer;
    }
}
