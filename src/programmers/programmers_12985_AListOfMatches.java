package programmers;

public class programmers_12985_AListOfMatches {

	public static void main(String[] args) {
		solution(8, 4, 7);
		//(output) 3
	}

	public static int solution(int n, int a, int b)
    {
        int answer = 0;

        for(int i=0;i<n;i++) {
        	if(Math.abs(a-b) == 1 && (a+b)%4 == 3) {
        		answer = i+1;
        		break;
        	}

        	if(a % 2 == 0)
        		a /= 2;
        	else
        		a = (a+1)/2;
        	
        	if(b % 2 == 0)
        		b /= 2;
        	else
        		b = (b+1)/2;
        }

        System.out.println(answer);
        return answer;
    }
}
