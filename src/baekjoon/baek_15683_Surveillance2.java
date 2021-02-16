package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class baek_15683_Surveillance2 {
	public static int N, M;
	public static int answer = 65;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] map = new int[N][M];
		ArrayList<ArrayList<Integer>> cctv = new ArrayList<>();		// cctv 좌표
		
		for (int i = 0; i < N; i++) {					// input
			for (int j = 0;j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] >= 1 && map[i][j] <= 5) {		// <cctv번호, x, y>
					ArrayList<Integer> c = new ArrayList<>();
					c.add(map[i][j]);
					c.add(i);
					c.add(j);
					cctv.add(c);
				}
			}
		}
		
		dfs(map, cctv, 0);
		
		System.out.println(answer);
	}
	
	public static void dfs(int[][] map, ArrayList<ArrayList<Integer>> cctv, int idx) {
		if(idx >= cctv.size()) {	// 마지막 cctv까지 감시 완료
			int zeroCnt = countZero(map);
			if (zeroCnt < answer) {	// 사각지대 최소 크기 업데이트
				answer = zeroCnt;
			}
			
//			for (int i = 0; i < map.length; i++) {
//				for (int j = 0; j < map[i].length; j++) {
//					System.out.print(map[i][j] + "\t");
//				}System.out.println();
//			}System.out.println("\n");
			return;
		}
		
		int cctvNum = cctv.get(idx).get(0);
		int cctvX = cctv.get(idx).get(1);
		int cctvY = cctv.get(idx).get(2);
		if (cctvNum == 1) {
			for (int i = 0; i < 4; i++) {
				int[][] copyMap = copyArr(map);			// cctv1
				onCamera(copyMap, cctvX, cctvY, i);		// 단방향 (4가지 방법)
				dfs(copyMap, cctv, idx+1);
			}
		} else if (cctvNum == 2) {						// cctv2
			for (int i = 0; i < 2; i++) {						// 양방향 (2가지 방법)
				int[][] copyMap = copyArr(map);
				onCamera(copyMap, cctvX, cctvY, i);
				onCamera(copyMap, cctvX, cctvY, i+2);
				dfs(copyMap, cctv, idx+1);
			}
		} else if (cctvNum == 3) {						// cctv3
			for (int i = 0; i < 4; i++) {						// 직각방향 (4가지 방법)
				int[][] copyMap = copyArr(map);	
				onCamera(copyMap, cctvX, cctvY, i);
				onCamera(copyMap, cctvX, cctvY, (i+1)%4);
				dfs(copyMap, cctv, idx+1);
			}
		} else if (cctvNum == 4) {						// cctv4
			for (int i = 0; i < 4; i++) {						// 세방향 (4가지 방법)
				int[][] copyMap = copyArr(map);	
				onCamera(copyMap, cctvX, cctvY, i);
				onCamera(copyMap, cctvX, cctvY, (i+1)%4);
				onCamera(copyMap, cctvX, cctvY, (i+2)%4);
				dfs(copyMap, cctv, idx+1);
			}
		} else if (cctvNum == 5) {						// cctv5
			int[][] copyMap = copyArr(map);
			for (int i = 0; i < 4; i++) {
				onCamera(copyMap, cctvX, cctvY, i);		// 네방향 (1가지 방법)
			}
			dfs(copyMap, cctv, idx+1);
		}
	}
	
	public static void onCamera(int[][] map, int x, int y, int dir) {	// 카메라 켜기
		int[] dx = {-1, 0, 1, 0};	// 상, 왼, 하, 오
		int[] dy = {0, -1, 0, 1};
		
		while (x >= 0 && x < N && y >= 0 && y < M) {
			if (map[x][y] == 0) {
				map[x][y] = -1;
			} else if (map[x][y] == 6) {
				break;
			}
			
			x = x + dx[dir];
			y = y + dy[dir];
		}
	}
	
	public static int countZero(int[][] map) {		// 사각지대 개수 구하기 함수
		int cnt = 0;
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	public static int[][] copyArr(int[][] map) {	// 2차원 배열 복사 함수
		int[][] copy = new int[map.length][map[0].length];
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				copy[i][j] = map[i][j];
			}
		}
		
		return copy;
	}
}


/*
4 6
0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 0 6 0
0 0 0 0 0 0
(output) 20
6 6
0 0 0 0 0 0
0 2 0 0 0 0
0 0 0 0 6 0
0 6 0 0 2 0
0 0 0 0 0 0
0 0 0 0 0 5
(output) 15
6 6
1 0 0 0 0 0
0 1 0 0 0 0
0 0 1 0 0 0
0 0 0 1 0 0
0 0 0 0 1 0
0 0 0 0 0 1
(output) 6
6 6
1 0 0 0 0 0
0 1 0 0 0 0
0 0 1 5 0 0
0 0 5 1 0 0
0 0 0 0 1 0
0 0 0 0 0 1
(output) 2
1 7
0 1 2 3 4 5 6
(output) 0
3 7
4 0 0 0 0 0 0
0 0 0 2 0 0 0
0 0 0 0 0 0 4
(output) 0
*/
