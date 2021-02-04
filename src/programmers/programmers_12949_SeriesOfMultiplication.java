package programmers;

public class programmers_12949_SeriesOfMultiplication {

	public static void main(String[] args) {
		int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
		int[][] arr2 = {{3, 3}, {3, 3}};
		solution(arr1, arr2);
		//(Outputs) {{15, 15}, {15, 15}, {15, 15}}

		int[][] num1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
		int[][] num2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
		solution(num1, num2);
		//(Outputs) {{22, 22, 11}, {36, 28, 18}, {29, 20, 14}}
	}

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i=0;i<arr1.length;i++)
        	for(int j=0;j<arr2[0].length;j++)
        		for(int k=0;k<arr1[0].length;k++)
        			answer[i][j] += arr1[i][k] * arr2[k][j];
        
//        for(int i=0;i<answer.length;i++) {
//        	for(int j=0;j<answer[i].length;j++) {
//        		System.out.print(answer[i][j] + "\t");
//        	}System.out.println();
//        }System.out.println();
        
        return answer;
    }
}
