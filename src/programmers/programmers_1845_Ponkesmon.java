package programmers;

import java.util.HashMap;
import java.util.Map;

public class programmers_1845_Ponkesmon {

	public static void main(String[] args) {
		int[] nums1 = {3, 1, 2, 3};
		solution(nums1);
		// (Outputs) 2
		
		int[] nums2 = {3, 3, 3, 2, 2, 4};
		solution(nums2);
		// (Outputs) 3
		
		int[] nums3 = {3, 3, 3, 2, 2, 2};
		solution(nums3);
		// (Outputs) 2
	}

	public static int solution(int[] nums) {
        int answer = 0;
        int sortNum = 0;
        int maxAns = nums.length / 2;
        Map<Integer, Integer> sorts = new HashMap<>();		// <폰켓몬 번호, 개수>
        
        for (int i = 0; i < nums.length; i++) {
        	if (!sorts.containsKey(nums[i])) {
        		sorts.put(nums[i], 1);
        	} else {
        		int before = sorts.get(nums[i]);
        		sorts.put(nums[i], before + 1);
        	}
        }
        
        sortNum = sorts.size();		// 폰켓몬 종류 수
        
        if (sortNum <= maxAns) {
        	answer = sortNum;
        } else {
        	answer = maxAns;
        }
        
        System.out.println(answer);
        
        return answer;
    }
}
