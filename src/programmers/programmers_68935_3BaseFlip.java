package programmers;

import java.util.Stack;

public class programmers_68935_3BaseFlip {

	public static void main(String[] args) {
		solution(45);
		//(Outputs) 7
		
		solution(125);
		//(Outputs) 229
	}

    public static int solution(int n) {
        int answer = 0;
        Stack<Integer> threeBase = new Stack<>();
        
        int rest = 0;
        if(n < 3) {
        	threeBase.add(n);
        } else {
            while(n >= 3) {
                rest = n % 3;
                n /= 3;
                threeBase.add(rest);

                if(n < 3)
                    threeBase.add(n);
            }
        }
        
        int size = threeBase.size();
        for(int i=0;i<size;i++) {
        	int num = threeBase.pop();
        	answer += num * Math.pow(3,  i);
        }
        
        System.out.println(answer);
        return answer;
    }
}
