package etc;

import java.util.*;

public class kakaoExam5_2 {
	public static void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		solution(stones, k);
		//(output) 3
	}
	
	public static int solution(int[] stones, int k) {
        int answer = 0;
        int sumStones = 0;
        Queue<Integer> st = new LinkedList<Integer>();
        
        for(int i=0;i<stones.length;i++)		//전체 밟을 수 있는 stone 개수 * 회수
        	sumStones += stones[i];
        
        System.out.println(sumStones);
        while(sumStones >= 0) {			//밟을 수 있는 stone 순서대로 큐에 저장
        	for(int j=0;j<stones.length;j++) {
        		if(stones[j] > 0) {
        			stones[j]--;
        			sumStones--;
        			st.add(j);
        		}
        	}
        	st.add(-1);
        }
        System.out.println(st.size());
        
        
        
        int bsize = st.size();
		for(int i=0;i<bsize;i++) {
			int n = st.poll();
			System.out.print(n + "\t");
			if(n == -1)
				System.out.println();
			st.add(n);
		}System.out.println();
		System.out.println();
        
        boolean jumpFail = false;
        int before = st.poll();
        while(!st.isEmpty()) {
        	int now = st.poll();
        	
        	if(now - before > k){	//점프 불가능
        		jumpFail = true;
        		break;
        	}
        	
        	if(now == -1) {
        		answer++;
        	}
        	
        	before = now;
        }
        
        /*int bsize = st.size();
		for(int i=0;i<bsize;i++) {
			int n = st.poll();
			System.out.print(n + "\t");
			st.add(n);
		}System.out.println();
		System.out.println();*/
        
        System.out.println(answer);
        
        return answer;
    }
}
