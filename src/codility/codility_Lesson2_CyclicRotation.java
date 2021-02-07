package codility;

public class codility_Lesson2_CyclicRotation {

	public static void main(String[] args) {
		int[] A1 = {3, 8, 9, 7, 6};
		solution(A1, 3);
		// (Outputs) 9, 7, 6, 3, 8
		

		int[] A2 = {0, 0, 0};
		solution(A2, 1);
		// (Outputs) 0, 0, 0
		

		int[] A3 = {1, 2, 3, 4};
		solution(A3, 4);
		// (Outputs) 1, 2, 3, 4
	}

    public static int[] solution(int[] A, int K) {
        int[] answer = new int[A.length];

        if(A.length == 0) {
            return answer;
        } else {
            K %= A.length;

            int[] temp = new int[K];
            for(int i=0;i<K;i++)
                temp[i] = A[A.length-K+i];
            
            for(int i=K;i<A.length;i++)
                answer[i] = A[i-K];
            for(int i=0;i<temp.length;i++)
                answer[i] = temp[i];
        }
        
        for(int i=0;i<answer.length;i++)
        	System.out.print(answer[i] + "   ");
        System.out.println();
        
        return answer;
    }
}
