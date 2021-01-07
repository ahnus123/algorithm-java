package programmers;

public class programmers_12899_NumberOf124Countries {
	public static void main(String[] args) {
		solution(1);
		//(Outputs) 1
		solution(2);
		//(Outputs) 2
		solution(3);
		//(Outputs) 4

		solution(4);
		//(Outputs) 11
		solution(5);
		//(Outputs) 12
		solution(6);
		//(Outputs) 14

		solution(7);
		//(Outputs) 21
		solution(8);
		//(Outputs) 22
		solution(9);
		//(Outputs) 24
		solution(10);
		//(Outputs) 41
	}

	public static String solution(int n) {
		String answer = "";
		
		while(n > 0) {
			int rest = n % 3;
			n /= 3;
			
			if(rest == 0) {
				rest = 4;
				n--;
			}
			
			answer = String.valueOf(rest) + answer;
		}
		
		System.out.println(answer);
		return answer;
	}
}
