package programmers;

public class programmers_67259_RacewayConstruction_DFS_Fail {
	
	static int MIN = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int[][] board1 = {{0,0,0}, {0,0,0}, {0,0,0}};
		//solution(board1);
		//(Outputs) 900
		
		int[][] board2 = {{0,0,0,0,0,0,0,1}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,1,0,0}, {0,0,0,0,1,0,0,0}, 
				{0,0,0,1,0,0,0,1}, {0,0,1,0,0,0,1,0}, {0,1,0,0,0,1,0,0}, {1,0,0,0,0,0,0,0}};
		//solution(board2);
		//(Outputs) 3800
		
		int[][] board3 = {{0,0,1,0}, {0,0,0,0}, {0,1,0,1}, {1,0,0,0}};
		//solution(board3);
		//(Outputs) 2100
		
		int[][] board4 = {{0,0,0,0,0,0}, {0,1,1,1,1,0}, {0,0,1,0,0,0}, {1,0,0,1,0,1}, {0,1,0,0,0,1}, {0,0,0,0,0,0}};
		//solution(board4);
		//(Outputs) 3200
		
	}

    public static int solution(int[][] board) {
        int answer = 0;
        int[][] visit = new int[board.length][board[0].length];
        
        visit[0][0] = 1;
        dfs(1, 0, 2, 100, board, visit);		// (0, 0) > (1, 0) 이동
        dfs(0, 1, 3, 100, board, visit);		// (0, 0) > (0, 1) 이동
        
        answer = MIN;
        System.out.println(answer);
        
        return answer;
    }
    
    public static void dfs(int x, int y, int dir, int cost, int[][] board, int[][] visit) {
    	int[] dx = {-1, 0, 1, 0};
    	int[] dy = {0, -1, 0, 1};
    	
    	visit[x][y] = 1;

		if(x == board.length-1 && y == board.length-1) {
			if(cost < MIN)		// 최소 비용 업데이트
				MIN = cost;
			
//			for(int i=0;i<board.length;i++) {
//				for(int j=0;j<board[0].length;j++) {
//					System.out.print(visit[i][j] + " ");
//				}System.out.println();
//			}System.out.println(cost + "\n");
			
			return;
		}
    	
    	for(int i=0;i<4;i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		if(inRange(nx, ny, board.length, board.length)) {
    			if(board[nx][ny] == 0 && visit[nx][ny] == 0) {
    				//System.out.println(nx + ", " + ny);
    				visit[nx][ny] = 1;
    				
    				if(dir == i)	// 직선 이동
    					dfs(nx, ny, i, cost+100, board, visit);
    				else		// 코너 이동
    					dfs(nx, ny, i, cost+600, board, visit);
    				
					visit[nx][ny] = 0;
    			}
    		}
    	}
    	
    	return;
    }
    
    public static boolean inRange(int x, int y, int maxX, int maxY) {
    	if(x >=0 && y >= 0 && x < maxX && y < maxY)
    		return true;
    	else
    		return false;
    }
}
