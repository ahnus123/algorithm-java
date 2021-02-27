package programmers;

public class programmers_17681_SecretMap {

	public static void main(String[] args) {
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		solution(5, arr1, arr2);
		// (Outputs) {"#####","# # #", "### #", "# ##", "#####"}
		

		int[] arr3 = {46, 33, 33 ,22, 31, 50};
		int[] arr4 = {27 ,56, 19, 14, 14, 10};
		solution(6, arr3, arr4);
		// (Outputs) {"######", "### #", "## ##", " #### ", " #####", "### # "}
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] arrMap1 = new int[n][n];
        int[][] arrMap2 = new int[n][n];
        
        for (int i = 0; i < arr1.length; i++) {
        	arrMap1[i] = decimalToBinary(arr1[i], n);
        	arrMap2[i] = decimalToBinary(arr2[i], n);
        }
        
        for (int i = 0; i < n; i++) {
        	String ans = "";
        	for (int j = 0; j < n; j++) {
        		if (arrMap1[i][j] == 0 && arrMap2[i][j] == 0) {
        			ans += " ";
        		} else {
        			ans += "#";
        		}
        	}
        	answer[i] = ans;
        }
        
        for (int i = 0; i < answer.length; i++) {
        	System.out.println(answer[i]);
        }
        
        return answer;
    }
	
	public static int[] decimalToBinary(int num, int length) {
		int[] binary = new int[length];
		
		int idx = length - 1;
		while (num > 1) {
			binary[idx] = num % 2;
			num /= 2;
			idx--;
		}
		binary[idx] = num;
		
		return binary;
	}
}
