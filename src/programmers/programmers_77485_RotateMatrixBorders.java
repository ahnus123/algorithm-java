package programmers;

public class programmers_77485_RotateMatrixBorders {

	public static void main(String[] args) {
		int[][] queries1 = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		int[] ans1 = solution(6, 6, queries1);
		printArr(ans1);
		//(Outputs) {8, 10, 25}

		int[][] queries2 = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
		int[] ans2 = solution(3, 3, queries2);
		printArr(ans2);
		//(Outputs) {1, 1, 5, 3}

		int[][] queries3 = {{1,1,100,97}};
		int[] ans3 = solution(100, 97, queries3);
		printArr(ans3);
		//(Outputs) {1}
	}

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows][columns];
        
        for (int i = 0; i < rows; i++) {			// 1부터 2차원 배열 초기화
        	for (int j = 0; j < columns; j++) {
        		arr[i][j] = i*columns + j + 1;
        	}
        }
        
        for (int i = 0; i < queries.length; i++) {	// 회전
        	int minNum = rotate(arr, queries[i]);
//        	printArr2(arr);
        	answer[i] = minNum;
        }
        
        return answer;
    }
    
    // 배열 회전 함수
    public static int rotate(int[][] arr, int[] query) {
    	int minNum = Integer.MAX_VALUE;
    	int temp = 0;
    	
    	for (int i = 0; i < query.length; i++) {
    		query[i]--;
    	}
    	
    	temp = arr[query[0]][query[1]];
    	for (int i = query[0]; i < query[2]; i++) {	// 아래 > 위로 이동(왼쪽)
    		arr[i][query[1]] = arr[i+1][query[1]];
    		if (minNum > arr[i+1][query[1]]) {
    			minNum = arr[i+1][query[1]];
    		}
    		// => minNum = Math.min(minNum, arr[i+1][query[1]]);
    	}
    	for (int j = query[1]; j < query[3]; j++) {	// 오른 > 왼으로 이동(아래쪽)
    		arr[query[2]][j] = arr[query[2]][j+1];
    		if (minNum > arr[query[2]][j+1]) {
    			minNum = arr[query[2]][j+1];
    		}
    	}
    	for (int i = query[2]; i > query[0]; i--) {	// 위 > 아래로 이동(오른쪽)
    		arr[i][query[3]] = arr[i-1][query[3]];
    		if (minNum > arr[i-1][query[3]]) {
    			minNum = arr[i-1][query[3]];
    		}
    	}
    	for (int j = query[3]; j > query[1]; j--) {	// 왼 > 오른으로 이동(위쪽)
    		arr[query[0]][j] = arr[query[0]][j-1];
    		if (minNum > arr[query[0]][j-1]) {
    			minNum = arr[query[0]][j-1];
    		}
    	}
    	arr[query[0]][query[1]+1] = temp;
		if (minNum > temp) {
			minNum = temp;
		}
    	
    	return minNum;
    }
    
    public static void printArr(int[] arr) {
    	for (int i = 0; i < arr.length; i++) {
    		System.out.print(arr[i] + "  ");
    	}System.out.println();
    }

    public static void printArr2(int[][] arr) {
    	for (int i = 0; i < arr.length; i++) {
    		for (int j = 0; j < arr[i].length; j++) {
    			System.out.print(arr[i][j] + "\t");
    		}System.out.println();
    	}System.out.println();
    }
}
