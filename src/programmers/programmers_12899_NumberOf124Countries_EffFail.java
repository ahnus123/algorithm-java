package programmers;

public class programmers_12899_NumberOf124Countries_EffFail {

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
        
        //3의 n승개수
        int power = 0;
        int countNum = 0;
        while(countNum < n) {	//3의 power까지의 합 < n < 3의 power+1까지의 
        	if(n <= countNum+Math.pow(3, power+1)) {
        		power++;
        		break;
        	}
        	power++;
        	countNum += Math.pow(3, power);
        }
        
        int[] finalNum = new int[power];
        for(int i=0;i<n-countNum-1;i++)		//1 더하기(124숫자로)
        	finalNum = addOne(finalNum);
        
        for(int i=power-1;i>=0;i--)
        	answer = answer + String.valueOf((int)Math.pow(2, finalNum[i]));
        
        System.out.println(answer);
        return answer;
    }
	
	public static int[] addOne(int[] num) {	//1 더하기(124숫자로)
		num[0]++;
		boolean add = true;
		
		while(add) {
			add = false;
			for(int i=0;i<num.length;i++) {
				if(num[i] == 3) {
					num[i] = 0;
					num[i+1]++;
					add = true;
					break;
				}
			}
		}
		
		return num;
	}
}
