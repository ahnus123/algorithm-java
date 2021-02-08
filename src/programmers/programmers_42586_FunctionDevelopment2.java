package programmers;

import java.util.ArrayList;

public class programmers_42586_FunctionDevelopment2 {

	public static void main(String[] args) {
		int[] progresses1 = {93, 30, 55};
		int[] speeds1 = {1, 30, 5};
		solution(progresses1, speeds1);
		//(Outputs) {2, 1}

		int[] progresses2 = {95, 90, 99, 99, 80, 99};
		int[] speeds2 = {1, 1, 1, 1, 1, 1}	;
		//solution(progresses2, speeds2);
		//(Outputs) {1, 3, 2}
	}

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] endDate = new int[progresses.length];
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<progresses.length;i++) {		// 완료일자 찾기
        	int end = ((100 - progresses[i]) / speeds[i]);
        	if(((100 - progresses[i]) % speeds[i]) == 0)
        		endDate[i] = end;
        	else
        		endDate[i] = end+1;
        }
        
        for(int i=0;i<endDate.length-1;i++)		// 배포일 맞추기
        	if(endDate[i] > endDate[i+1])
        		endDate[i+1] = endDate[i];

        int count = 1;
        for(int i=0;i<endDate.length-1;i++) {	// 배포일별 배포되는 기능 개수 카운트
        	if(endDate[i] != endDate[i+1]) {
        		ans.add(count);
        		count = 1;
        	} else {
        		count++;
        	}
        	
    		if(i == endDate.length-2)
    			ans.add(count);
        }
        
        answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++) {		// 정답 셋팅
        	answer[i] = ans.get(i);
        	System.out.println(answer[i]);
        }
        
        return answer;
    }
}
