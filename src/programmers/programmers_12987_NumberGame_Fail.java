package programmers;

public class programmers_12987_NumberGame_Fail {

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
        
        answer = permutation(A, B, 0, B.length, B.length);
        
        System.out.println(answer);
        return answer;
    }
    
    // 순열 함수
    public static int permutation(int[] A, int[] B, int depth, int n, int r) {
    	int ans = 0;
    	
    	if(depth == r) {
		   int win = 0;
		   for(int i=0;i<A.length;i++)		// B팀 우승 횟수
			   if(A[i] < B[i])
				   win++;
//		   for(int i=0;i<B.length;i++)
//			   System.out.print(B[i] + " ");
//		   System.out.println("==" + win + "==");
			   
		   return win;
	   }
	   
	   for(int i=depth;i<n;i++) {
		   swap(B, depth, i);
		   
		   int res = permutation(A, B, depth+1, n, r);	// 순열 구하기
		   if(res > 0 && res > ans)		// 최대값 업데이트
			   ans = res;
		   
		   swap(B, depth, i);
	   }
	   
	   return ans;
   }
   
   public static void swap(int[] arr, int depth, int i) {
	   int temp = arr[depth];
	   arr[depth] = arr[i];
	   arr[i] = temp;
   }
}
