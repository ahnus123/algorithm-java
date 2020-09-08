package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

class Robot {	//로봇 좌표 클래스
	int x1;		int y1;
	int x2;		int y2;
	
	Robot(int x1, int y1, int x2, int y2) {
		this.x1 = x1;	this.y1 = y1;
		this.x2 = x2;	this.y2 = y2;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Robot) {
			Robot temp = (Robot) obj;
			return x1==temp.x1 && y1==temp.y1 && x2==temp.x2 && y2==temp.y2;
		}
		return false;
	}
	
	public int hashCode() {
		return Objects.hash(x1, y1, x2, y2);
	}
}

public class programmers_60063_MovingBlocks {

	public static void main(String[] args) {
		int[][] board1 = {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
		//solution(board1);
		//(output) 7
		
		int[][] board2 = {{0, 0, 0, 0, 0, 0, 1},
				{1, 1, 1, 1, 0, 0, 1},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 1, 1, 1, 0},
				{0, 1, 1, 1, 1, 1, 0},
				{0, 0, 0, 0, 0, 1, 1},
				{0, 0, 1, 0, 0, 0, 0}};
		//solution(board2);
		//(output) 21
		
		int[][] board3 = {{0, 0, 0, 0, 0, 0, 1},
				{1, 1, 1, 1, 0, 0, 1},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 1, 1, 0, 0},
				{0, 1, 1, 1, 1, 1, 0},
				{0, 0, 0, 0, 0, 1, 0},
				{0, 0, 1, 0, 0, 0, 0}};
		//solution(board3);
		//(output) 11
		
		int[][] board4 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 1, 1, 1, 1, 1, 0, 0},
				{1, 1, 1, 1, 1, 1, 1, 1, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 1, 1, 1, 1, 0, 0},
				{0, 1, 1, 1, 1, 1, 1, 1, 1},
				{0, 0, 1, 1, 1, 1, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 1, 1, 1, 1, 1, 1, 0}};
		solution(board4);
		//(output) 33
	}

	public static int solution(int[][] board) {		//BFS
		int answer = 0;
		int n = board.length;
		Queue<HashMap<Robot, Integer>> q = new LinkedList<>();
		Set<Robot> visited = new HashSet<>();
		
		Robot r = new Robot(0, 0, 0, 1);	//로봇 처음 위치
		HashMap<Robot, Integer> first = new HashMap<>();
		first.put(r, 0);
		q.add(first);
		visited.add(r);
		
		while(!q.isEmpty()) {
			HashMap<Robot, Integer> now = q.poll();
			Robot robot = null;
			int move = 0;
			for(Map.Entry<Robot, Integer> entry : now.entrySet()) {
				robot = entry.getKey();		move = entry.getValue();
			}
			//System.out.println(move+" : ("+robot.x1+","+robot.y1+") / ("+robot.x2+","+robot.y2+")");
			
			if((robot.x1 == n-1 && robot.y1 == n-1) || (robot.x2 == n-1 && robot.y2 == n-1)) {	//(n-1,n-1) 도착
				answer = move;
				break;
			}
			
			int[] dx = {-1, 0, 1, 0};
			int[] dy = {0, 1, 0, -1};
			
			for(int i=0;i<4;i++) {		//4방향 평행이동(아래쪽, 오른쪽, 위쪽, 왼쪽)
				Robot nRobot = new Robot(robot.x1+dx[i], robot.y1+dy[i], robot.x2+dx[i], robot.y2+dy[i]);	//이동한 로봇
				
				if(!visited.contains(nRobot)) {		//로봇 방문 체크
					if(inRange(nRobot.x1, nRobot.y1, board.length)
							&& inRange(nRobot.x2, nRobot.y2, board.length)) {	//이동한 로봇 범위 체크
						if(board[nRobot.x1][nRobot.y1] == 0 && board[nRobot.x2][nRobot.y2] == 0) {	//로봇 이동 가능여부 체크
							HashMap<Robot, Integer> next = new HashMap<>();
							next.put(nRobot, move+1);
							q.add(next);
							visited.add(nRobot);
						}
					}
				}
			}
			
			if(Math.abs(robot.x1-robot.x2) == 1) {		// |자 로봇
				Robot nRobot = new Robot(robot.x1+1, robot.y1, robot.x2, robot.y2+1);	//아래쪽 축 기준 - 오른쪽 90도 회전
				if(!visited.contains(nRobot)) {
					if(inRange(nRobot.x2-1, nRobot.y2, n) && inRange(nRobot.x2, nRobot.y2, n)) {
						if(board[nRobot.x2-1][nRobot.y2] == 0 && board[nRobot.x2][nRobot.y2] == 0) {
							HashMap<Robot, Integer> next = new HashMap<>();
							next.put(nRobot, move+1);
							q.add(next);
							visited.add(nRobot);
						}
					}
				}
				Robot nRobot2 = new Robot(robot.x1+1, robot.y1-1, robot.x2, robot.y2);	//아래쪽 축 기준 - 왼쪽 90도 회전
				if(!visited.contains(nRobot2)) {
					if(inRange(nRobot2.x1-1, nRobot2.y1, n) && inRange(nRobot2.x1, nRobot2.y1, n)) {
						if(board[nRobot2.x1-1][nRobot2.y1] == 0 && board[nRobot2.x1][nRobot2.y1] == 0) {
							HashMap<Robot, Integer> next = new HashMap<>();
							next.put(nRobot2, move+1);
							q.add(next);
							visited.add(nRobot2);
						}
					}
				}
				Robot nRobot3 = new Robot(robot.x1, robot.y1, robot.x2-1, robot.y2+1);	//위쪽 축 기준 - 오른쪽 90도 회전
				if(!visited.contains(nRobot3)) {
					if(inRange(nRobot3.x2+1, nRobot3.y2, n) && inRange(nRobot3.x2, nRobot3.y2, n)) {
						if(board[nRobot3.x2+1][nRobot3.y2] == 0 && board[nRobot3.x2][nRobot3.y2] == 0) {
							HashMap<Robot, Integer> next = new HashMap<>();
							next.put(nRobot3, move+1);
							q.add(next);
							visited.add(nRobot3);
						}
					}
				}
				Robot nRobot4 = new Robot(robot.x1, robot.y1-1, robot.x2-1, robot.y2);	//위쪽 축 기준 - 왼쪽 90도 회전
				if(!visited.contains(nRobot4)) {
					if(inRange(nRobot4.x1+1, nRobot4.y1, n) && inRange(nRobot4.x1, nRobot4.y1, n)) {
						if(board[nRobot4.x1+1][nRobot4.y1] == 0 && board[nRobot4.x1][nRobot4.y1] == 0) {
							HashMap<Robot, Integer> next = new HashMap<>();
							next.put(nRobot4, move+1);
							q.add(next);
							visited.add(nRobot4);
						}
					}
				}
			} else if(Math.abs(robot.y1-robot.y2) == 1) {		//--자 로봇
				Robot nRobot = new Robot(robot.x1-1, robot.y1+1, robot.x2, robot.y2);	//오른쪽 축 기준 - 오른쪽 90도 회전
				if(!visited.contains(nRobot)) {
					if(inRange(nRobot.x1, nRobot.y1-1, n) && inRange(nRobot.x1, nRobot.y1, n)) {
						if(board[nRobot.x1][nRobot.y1-1] == 0 && board[nRobot.x1][nRobot.y1] == 0) {
							HashMap<Robot, Integer> next = new HashMap<>();
							next.put(nRobot, move+1);
							q.add(next);
							visited.add(nRobot);
						}
					}
				}
				Robot nRobot2 = new Robot(robot.x1, robot.y1+1, robot.x2+1, robot.y2);	//오른쪽 축 기준 - 왼쪽 90도 회전
				if(!visited.contains(nRobot2)) {
					if(inRange(nRobot2.x1+1, nRobot2.y1-1, n) && inRange(nRobot2.x2, nRobot2.y2, n)) {
						if(board[nRobot2.x1+1][nRobot2.y1-1] == 0 && board[nRobot2.x2][nRobot2.y2] == 0) {
							HashMap<Robot, Integer> next = new HashMap<>();
							next.put(nRobot2, move+1);
							q.add(next);
							visited.add(nRobot2);
						}
					}
				}
				Robot nRobot3 = new Robot(robot.x1-1, robot.y1, robot.x2, robot.y2-1);	//왼쪽 축 기준 - 왼쪽 90도 회전
				if(!visited.contains(nRobot3)) {
					if(inRange(nRobot3.x1, nRobot3.y1+1, n) && inRange(nRobot3.x1, nRobot3.y1, n)) {
						if(board[nRobot3.x1][nRobot3.y1+1] == 0 && board[nRobot3.x1][nRobot3.y1] == 0) {
							HashMap<Robot, Integer> next = new HashMap<>();
							next.put(nRobot3, move+1);
							q.add(next);
							visited.add(nRobot3);
						}
					}
				}
				Robot nRobot4 = new Robot(robot.x1, robot.y1, robot.x2+1, robot.y2-1);	//왼쪽 축 기준 - 왼쪽 90도 회전
				if(!visited.contains(nRobot4)) {
					if(inRange(nRobot4.x2, nRobot4.y2+1, n) && inRange(nRobot4.x2, nRobot4.y2, n)) {
						if(board[nRobot4.x2][nRobot4.y2+1] == 0 && board[nRobot4.x2][nRobot4.y2] == 0) {
							HashMap<Robot, Integer> next = new HashMap<>();
							next.put(nRobot4, move+1);
							q.add(next);
							visited.add(nRobot4);
						}
					}
				}
			}
		}

		System.out.println(answer);
        return answer;
	}

	public static boolean inRange(int x, int y, int n) {		//좌표 범위 체크
		if(x >= 0 && y >= 0 && x < n && y < n)
			return true;
		else
			return false;
	}
}
