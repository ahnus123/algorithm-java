package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class programmers_42626_MoreSpicy_Fail {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		solution(scoville, 7);
		//(Outputs) 2
	}

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        boolean isEnd = false;
        ArrayList<Integer> list = new ArrayList<>();
        
        Arrays.sort(scoville);
        for(int i=0;i<scoville.length;i++)
        	list.add(scoville[i]);
        Collections.sort(list);
        
        while(!isEnd) {
        	if(list.size() < 2)
        		break;
        	
        	int min1 = list.get(0);
        	int min2 = list.get(1);
        	int scov = min1 + 2 * min2;
        	
        	if(min1 >= K)
        		break;
        	
        	list.remove(1);
        	list.remove(0);
        	
        	list.add(min1 + 2*min2);
        	Collections.sort(list);
        	answer++;
        }
        
        System.out.println(answer);
        return answer;
    }
}
