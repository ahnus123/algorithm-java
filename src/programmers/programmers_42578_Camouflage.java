package programmers;

import java.util.HashMap;

public class programmers_42578_Camouflage {
	public static void main(String[] args) {
		String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		solution(clothes1);
		//(Outputs) 5

		String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		solution(clothes2);
		//(Outputs) 3
	}

    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> count = new HashMap<>();
        
        for(int i=0;i<clothes.length;i++) {
        	if(count.containsKey(clothes[i][1]))
        		count.put(clothes[i][1], count.get(clothes[i][1])+1);
        	else
        		count.put(clothes[i][1], 1);
        }
        
        for(String key : count.keySet())
        	answer *= count.get(key) + 1;
        answer--;
        
        System.out.println(answer);
        
        return answer;
    }
}
