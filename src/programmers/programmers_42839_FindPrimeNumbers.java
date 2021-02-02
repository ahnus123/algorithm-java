package programmers;

import java.util.HashSet;

public class programmers_42839_FindPrimeNumbers {
	public static HashSet<Integer> resSet = new HashSet<>();

	public static void main(String[] args) {
		solution("17");
		//(Outputs) 3

		//solution("011");
		//(Outputs) 2
	}

    public static int solution(String numbers) {
        int answer = 0;
        String[] cards = new String[numbers.length()];
        
        for(int i=0;i<numbers.length();i++)
        	cards[i] = numbers.charAt(i) + "";
       
        for(int i=1;i<=cards.length;i++) {
        	String[] res = new String[i];
        	combination(cards, res, cards.length, i, 0, 0);		// 조합으로 카드 고르기(1~card 개수)
        }
        
        
        for(Integer n : resSet)
        	if(isPrimeNum(n) && n > 1)		// 소수 여부 
        		answer++;

        System.out.println(answer);
        
        return answer;
    }
    
    public static void combination(String[] arr, String[] res, int n, int r, int idx, int target) {
    	if(r==0) {
//    		System.out.println("COM");
//    		for(int i=0;i<res.length;i++) {
//    			System.out.print(res[i] + "    ");
//    		}System.out.println();
    		
    		permutation(res, 0, res.length, res.length);	// 조합으로 고른 카드를 순열로 나열
    		return;
    	}
    	
    	if(target == n) {
    		return;
    	}
    	
    	res[idx] = arr[target];
    	combination(arr, res, n, r-1, idx+1, target+1);
    	combination(arr, res, n, r, idx, target+1);
    }
    
    public static void permutation(String[] arr, int depth, int n, int r) {
    	if (depth == r) {
    		String str = "";

    		for(int i=0;i<arr.length;i++)
    			str += arr[i];
    		resSet.add(Integer.parseInt(str));
        	//System.out.println(Integer.parseInt(str));
    		
    		return;
    	}
    	
    	for(int i=depth;i<n;i++) {
    		swap(arr, depth, i);
    		permutation(arr, depth+1, n, r);
    		swap(arr, depth, i);
    	}
    }
    
    public static void swap(String[] arr, int depth, int i) {
    	String temp = arr[depth];
    	arr[depth] = arr[i];
    	arr[i] = temp;
    }
    
    public static boolean isPrimeNum(int num) {		// 소수 여부 
    	for(int i=2;i<(int)Math.sqrt(num)+1;i++)
    		if(num % i == 0)
    			return false;
    	
    	return true;
    }
}
