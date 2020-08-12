package programmers;

public class programmers_62048_AFineSquare {

	public static void main(String[] args) {
		solution(8, 12);
		//(output) 80
		
		solution(100000000, 999999999);
		//(output) 99999998800000002 (X)
	}

	static public long solution(int w, int h) {
        long answer = 0;
        //double slope = (double)(Long.valueOf(h)/Long.valueOf(w));		//기울기(y=mx)

        for(int i=1;i<w;i++)
        	answer += 2 * Math.floor(Long.valueOf(h)*i/Long.valueOf(w));//멀쩡한 사각형 * 2
        
        System.out.println(answer);
        return answer;
    }
}