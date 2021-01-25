package programmers;

import java.util.Arrays;

public class programmers_12987_NumberGame_EffFail {

	public static void main(String[] args) {
		int[] A1 = {5,1,3,7};
		int[] B1 = {2,2,6,8};
		solution(A1, B1);
		//(Outputs) 3
		
		int[] A2 = {2,2,2,2};
		int[] B2 = {1,1,1,1};
		solution(A2, B2);
		//(Outputs) 0
	}

    public static int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);		// 배열 정렬
        Arrays.sort(B);
        
        for(int i=0;i<B.length;i++) {
        	int win = 0;
        	
        	// A[0] < B[0], ..., A[A.length-1] < B[B.length-1] 비교(A.length번 비교)
        	// A[0] < B[1], ..., A[A.length-2] < B[B.length-1] 비교(A.length-1번 비교)
        	// ...
        	// A[0] < B[B.length-1] 비교(1번 비교)
        	for(int j=0;j<B.length-i;j++)
        		if(A[j] < B[i+j])
        			win++;
        	
        	if(win > answer)
        		answer = win;
        }
        
        System.out.println(answer);
        return answer;
    }
}
