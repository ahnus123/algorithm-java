package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class programmers_67259_RacewayConstruction_BFS {
	
	static int MIN = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int[][] board1 = {{0,0,0}, {0,0,0}, {0,0,0}};
		//solution(board1);
		//(Outputs) 900
		
		int[][] board2 = {{0,0,0,0,0,0,0,1}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,1,0,0}, {0,0,0,0,1,0,0,0}, 
				{0,0,0,1,0,0,0,1}, {0,0,1,0,0,0,1,0}, {0,1,0,0,0,1,0,0}, {1,0,0,0,0,0,0,0}};
		solution(board2);
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
        
        answer = bfs(0, 0, board);
        
        System.out.println(answer);
        return answer;
    }
    
    //dir(0 : 위, 1 : 왼, 2 : 아래, 3 : 오른)
    public static int bfs(int x, int y, int[][] board) {
    	int ans = Integer.MAX_VALUE;
    	int[][] minBoard = new int[board.length][board[0].length];
    	
    	for(int i=0;i<minBoard.length;i++)		// 좌표별 최소 금액
    		for(int j=0;j<minBoard[i].length;j++)
    			minBoard[i][j] = Integer.MAX_VALUE;
    	
    	Queue<int[]> q = new LinkedList<>();	// {x, y, dir, cost}
    	int[] first = {x, y, -1, -500};		// 맨 처음은 방향이 없으니까 무조건 +600됨을 고려
    	q.add(first);
    	
    	while(!q.isEmpty()) {
    		int[] dx = {-1, 0, 1, 0};
    		int[] dy = {0, -1, 0, 1};
    		int[] now = q.poll();
    		
//    		if(now[0] == board.length-1 && now[1] == board[0].length-1) {
//    			for(int i=0;i<board.length;i++) {
//    				for(int j=0;j<board[i].length;j++) {
//    					if(minBoard[i][j] == Integer.MAX_VALUE)
//    						System.out.print(0 + "\t");
//    					else
//    						System.out.print(minBoard[i][j] + "\t");
//    				}System.out.println();
//    			}System.out.println("\n");
//    		}
    		
    		for(int i=0;i<4;i++) {
    			int nx = now[0] + dx[i];
    			int ny = now[1] + dy[i];
    			
    			if(inRange(nx, ny, board.length, board[0].length) && board[nx][ny] == 0) {	//nx, ny가 범위 내 && 벽 없으면
    				if(now[2] == i) {	// 이전과 방향이 같으면(직선)
    					if(now[3]+100 <= minBoard[nx][ny]) {
	    					int[] next = {nx, ny, i, now[3]+100};
	        				q.add(next);
	        				minBoard[nx][ny] = now[3]+100;
    					}
    				} else {	// 이전과 방향이 다르면(코너)
    					if(now[3]+600 <= minBoard[nx][ny]) {
	    					int[] next = {nx, ny, i, now[3]+600};
	        				q.add(next);
	        				minBoard[nx][ny] = now[3]+600;
    					}
    				}
    			}
    		}
    		
    	}
    	
    	ans = minBoard[minBoard.length-1][minBoard[0].length-1];
    	
    	return ans;
    }
    
    public static boolean inRange(int x, int y, int maxX, int maxY) {
    	if(x >=0 && y >= 0 && x < maxX && y < maxY)
    		return true;
    	else
    		return false;
    }
}
