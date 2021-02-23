package programmers;

import java.util.LinkedList;
import java.util.Queue;

class Point {
	int x;
	int y;
	int dis;
	int[][] visit;
	
	public Point(int x, int y, int dis) {
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
}

public class programmers_1844_ShortestDistanceOnTheGameMap_TimeFail {

	public static void main(String[] args) {
		int[][] maps1 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		solution(maps1);
		// (Outputs) 11
		
		int[][] maps2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
		solution(maps2);
		// (Outputs) -1
	}

	public static int solution(int[][] maps) {
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int[][] visit = new int[maps.length][maps[0].length];
        Queue<Point> q = new LinkedList<>();
        
        q.add(new Point(0, 0, 1));
        
        while(!q.isEmpty()) {			// BFS로 길찾기
        	Point now = q.poll();
        	visit[now.x][now.y] = 1;
//        	System.out.println("(" + now.x + ", " + now.y + ") -> " + now.dis);	// 방문 이력 출력
        	
        	if (now.x == maps.length - 1 && now.y == maps[0].length - 1) {		// 적팀 진영 도착
        		answer = now.dis;
        		break;
        	}
        	
        	for (int i = 0; i < dx.length; i++) {
        		int nx = now.x + dx[i];
        		int ny = now.y + dy[i];
        		if (inRange(nx, ny, maps.length, maps[0].length)) {
	        		if (maps[nx][ny] == 1 && visit[nx][ny] == 0) {
	        			q.add(new Point(nx, ny, now.dis + 1));
	        		}
        		}
        	}
        }
        
        if (answer == 0) {		// 적팀 진영 도착 불가능
        	answer = -1;
        }
        
        System.out.println(answer);
        return answer;
    }
	
	public static boolean inRange(int x, int y, int maxX, int maxY) {	// 맵 범위 체크 함수
		if (x >= 0 && x < maxX && y >= 0 && y < maxY) {
			return true;
		} else {
			return false;
		}
	}
}
