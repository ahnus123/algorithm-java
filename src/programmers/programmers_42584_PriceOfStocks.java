package programmers;

public class programmers_42584_PriceOfStocks {

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		solution(prices);
		//(Outputs) {4, 3, 1, 1, 0)
	}

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0;i<prices.length-1;i++) {
        	for(int j=i+1;j<prices.length;j++) {
        		answer[i]++;
        		
        		if(prices[i] > prices[j])
        			break;
        	}
        }
        
        return answer;
    }
}
