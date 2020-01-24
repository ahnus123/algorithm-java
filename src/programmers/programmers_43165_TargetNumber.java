package programmers;

public class programmers_43165_TargetNumber {
	static int answer = 0;

	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		solution(numbers, 3);
		//(output) 5
	}

	public static int solution(int[] numbers, int target) {
        calc(0, numbers.length, 0, target, numbers);	//
        
        System.out.println(answer);
        return answer;
    }
	
	//DFS
	public static void calc(int now, int end, int calcNum, int target, int[] numbers) {
		if(now == end) {		//numbers의 모든 요소를 계산
			if(calcNum == target)		//결과가 target과 같으면
				answer++;				//정답 추가

			return;
		}
		
		calc(now+1, end, calcNum + numbers[now], target, numbers);		//다음 숫자 더하기
		calc(now+1, end, calcNum - numbers[now], target, numbers);		//다음 숫자 빼기
	}
}
