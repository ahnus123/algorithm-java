package programmers;

import java.util.ArrayList;
import java.util.List;

public class programmers_16787_NNotation {

	public static void main(String[] args) {
		solution(2, 4, 2, 1);
		//(output) 0111
		
		solution(16, 16, 2, 1);
		//(output) 02468ACE11111111
		
		solution(16, 16, 2, 2);
		//(output) 13579BDF01234567
	}

	static public String solution(int n, int t, int m, int p) {		//n:진법, t:미리 구할 숫자 갯수, m:게임 참가 인원, p:튜브 순서
        String answer = "";
        String nNotation = "0";
        char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    	int num = 1;
        while(true) {
        	int res;
        	int temp = num;
        	List<Character> nNum = new ArrayList<Character>();
        	
        	while(temp != 0) {		//10진수 > N 진법 변환
        		res = temp % n;
        		temp /= n;
        		nNum.add(numbers[res]);
        	}

        	for(int i=nNum.size()-1;i>=0;i--)
        		nNotation += nNum.get(i);
        	
        	num++;
        	if(nNotation.length() >= t * m)
        		break;
        }
        System.out.println(nNotation);		//print(N진수 전체 수열)
        
        for(int i=0;i<t;i++)			//튜브가 말해야하는 숫자
        	answer += nNotation.charAt((i*m)+(p-1));
        
        System.out.println(answer);
        return answer;
    }
}
