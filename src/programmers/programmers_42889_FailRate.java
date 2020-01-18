package programmers;

import java.util.*;

public class programmers_42889_FailRate {

	public static void main(String[] args) {
		programmers_42889_FailRate m = new programmers_42889_FailRate();
		
		int N1 = 5;
		int[] stages1 = {2, 1, 2, 6, 2, 4, 3, 3};
		m.solution(N1, stages1);
		//(output) 3, 4, 2, 1, 5
		
		int N2 = 4;
		int[] stages2 = {4, 4, 4, 4, 4};
		m.solution(N2, stages2);
		//(output) 4, 1, 2, 3
	}

	public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] stage = new int[N + 1];		//스테이지별 머무르는 사람 수
        int[] user = new int[N + 1];		//스테이지별 총 인원 수
        Map<Integer, Double> rate = new HashMap<Integer, Double>();		//(스테이지, 실패율)
        
        for(int i=0;i<stages.length;i++)		//스테이지별 머무르는 사람 수 계산
        	stage[stages[i] - 1]++;
        
        user[user.length - 1] = stage[stage.length - 1];	//스테이지별 총 인원 수 계산
        for(int i=stage.length-2;i>=0;i--)
        	user[i] = stage[i] + user[i + 1];
        
        for(int i=0;i<stage.length - 1;i++) {		//실패율 계산
        	if(stage[i] != 0)
        		rate.put(i + 1, (double)stage[i] / user[i]);
        	else
        		rate.put(i + 1, 0.0);
        }
        
        List<Integer> valueList = new ArrayList<>(rate.keySet());		//실패율 내림차순
        Collections.sort(valueList, (o1, o2)->(rate.get(o2).compareTo(rate.get(o1))));
        
        for(int i=0;i<valueList.size();i++) {		//정답 입력
        	answer[i] = valueList.get(i);
        	System.out.println(valueList.get(i) + " ");
        }
        
        return answer;
    }
}
