package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class programmers_42587_Printer {

	public static void main(String[] args) {
		int[] priorities1 = {2, 1, 3, 2};
		solution(priorities1, 2);
		//(Outputs) 1

		int[] priorities2 = {1, 1, 9, 1, 1, 1};
		solution(priorities2, 0);
		//(Outputs) 5
	}

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> wait = new LinkedList<>();
        Queue<int[]> print = new LinkedList<>();
        
        for(int i=0;i<priorities.length;i++) {
        	int[] a = {i, priorities[i]};
        	wait.add(a);
        }
        
        while(!wait.isEmpty()) {
        	int[] now = wait.poll();
        	
        	if(hasHigher(now[1], wait))
        		wait.add(now);
        	else
        		print.add(now);
        }
        
        int size = print.size();
        
        for(int i=0;i<size;i++) {
        	int[] now = print.poll();
        	if(now[0] == location) {
        		answer = i+1;
        		break;
        	}
        }
        
        System.out.println(answer);
        return answer;
    }
    
    public static boolean hasHigher(int pri, Queue<int[]> q) {
    	boolean res = false;
    	
    	int size = q.size();
    	for(int i=0;i<size;i++) {	// 높은 우선순위의 문서가 있는지 체크
    		int[] now = q.poll();
    		if(now[1] > pri)
    			res = true;
    		q.add(now);
    	}
    	
    	return res;
    }
}
