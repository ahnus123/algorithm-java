package programmers;

import java.util.Arrays;

public class programmers_12987_NumberGame {

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
        
        int idxB = 0;
        // [1, 3, 5, 7] / [2, 2, 6, 8]
        // 1 < 2 비교 (idxB -> 1, answer = 1)
        // 3 < 2 비교 (idxB -> 1)
        // 3 < 6 비교 (idxB -> 2, answer = 2)
        // 5 < 8 비교 (idxB -> 3, answer = 3)
        for(int i=0;i<A.length;i++) {
        	for(int j=idxB;j<B.length;j++) {
        		if(A[i] < B[j]) {
        			answer++;
        			idxB = j + 1;
        			break;
        		}
        	}
        }
        
        System.out.println(answer);
        return answer;
    }
}

//[참고] [https://velog.io/@e7838752/programmers-numberGame]
