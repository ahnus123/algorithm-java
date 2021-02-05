package programmers;

import java.util.TreeSet;

public class programmers_68644_PickTwoAndAdd {
	public static TreeSet<Integer> ansSet = new TreeSet<>();

	public static void main(String[] args) {
		int[] numbers1 = {2,1,3,4,1};
		//solution(numbers1);
		//(Outputs) {2,3,4,5,6,7}

		int[] numbers2 = {5,0,2,7};
		solution(numbers2);
		//(Outputs) {2,5,7,9,12}
	}

    public static int[] solution(int[] numbers) {
        int[] answer = {};
        
        int[] arr = new int[2];
        combination(arr, numbers, numbers.length, 2, 0, 0);
        
        int idx = 0;
        answer = new int[ansSet.size()];
        for(Integer num : ansSet) {
        	answer[idx] = num;
        	idx++;
        	System.out.print(num + "\t");
        }System.out.println();
        
        return answer;
    }
    
    public static void combination(int[] arr, int[] numbers, int n, int r, int idx, int target) {
    	if(r == 0) {
    		ansSet.add(arr[0]+arr[1]);
    		return;
    	}
    	
    	if(target == n)
    		return;
    	
    	arr[idx] = numbers[target];
    	combination(arr, numbers, n, r-1, idx+1, target+1);
    	combination(arr, numbers, n, r, idx, target+1);
    }
}
