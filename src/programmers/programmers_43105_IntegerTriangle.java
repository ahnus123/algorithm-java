package programmers;

import java.util.ArrayList;
import java.util.List;

public class programmers_43105_IntegerTriangle {

	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		solution(triangle);
		//(output) 30
	}

	public static int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        

        dp[0][0] = triangle[0][0];
        for(int i=1;i<triangle.length;i++) {
        	for(int j=0;j<triangle[i].length;j++) {
        		if(j == 0) {				//해당 층의 첫번째 노드
        			dp[i][j] = dp[i - 1][j] + triangle[i][j];
        		} else if(j == triangle[i].length - 1) {		//해당 층의 마지막 노드
        			dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
        		} else {					//해당 층의 가운데 노드들
        			if(dp[i - 1][j - 1] > dp[i - 1][j]) {
        				dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
        			} else {
        				dp[i][j] = dp[i - 1][j] + triangle[i][j];
        			}
        		}
        	}
        }
        
        int max = -1;
        for(int i=0;i<dp.length;i++)
        	if(max < dp[dp.length - 1][i])
        		max = dp[dp.length - 1][i];
        
        answer = max;
        System.out.println("answer : " + answer);
        
        return answer;
    }
}
