package programmers;

public class programmers_42842_Carpet {

	public static void main(String[] args) {
		solution(10, 2);
		//(Outputs) {4, 3};

		solution(8, 1);
		//(Outputs) {3, 3};

		solution(24, 24);
		//(Outputs) {8, 6};
	}

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int maxN = (int) Math.sqrt(brown + yellow) + 1;		// 사각형 합의 제곱근
        
        for(int i=1;i<maxN;i++) {
        	int j = (brown + yellow) / i;
        	if((i * 2) + ((j-2) * 2) == brown && ((i-2) * (j-2)) == yellow) {
        		answer[0] = j;	// 가로
        		answer[1] = i;	// 세로
        		break;
        	}
        }
        
        System.out.println(answer[0] + ", " + answer[1]);
        return answer;
    }
}
