package softeer;

import java.util.ArrayList;
import java.util.Scanner;

public class softeer_577_ThePathThatTheRobotPassedBy {
	public static int[] DX = {-1, 0, 1, 0};		// 상, 좌, 하, 우
	public static int[] DY = {0, -1, 0, 1};
	public static char[] DIR = {'^', '<', 'v', '>'};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// input
		int H = sc.nextInt();
		int W = sc.nextInt();
		char[][] map = new char[H][W];
		for (int i = 0 ; i < H; i++) {
			String m = sc.next();
			for (int j = 0; j < W; j++) {
				map[i][j] = m.charAt(j);
			}
		}
		
		int[] start = findStart(map);	// 시작 지점 찾기
		
		int x = start[0];
		int y = start[1];
		int firstDir = 0;
		int dir = 0;
		String ans = "";
		
		firstDir = findNextDir(map, x, y);
		dir = firstDir;
		map[x][y] = '.';
		
		while (!allVisit(map)) {
			int nextDir = findNextDir(map, x, y);
			
			// 어느 방향으로 얼만큼 전환할건지
			int diff = nextDir - dir;
			
			if (diff < 0) {
				if (Math.abs(diff) < 3) {
					for (int j = 0; j < Math.abs(diff); j++) {
						ans = ans + "R";
					}
				} else {
					for (int j = 0; j < 4 - Math.abs(diff); j++) {
						ans = ans + "L";
					}
				}
			} else {
				if (Math.abs(diff) < 3) {
					for (int j = 0; j < Math.abs(diff); j++) {
						ans = ans + "L";
					}
				} else {
					for (int j = 0; j < 4 - Math.abs(diff); j++) {
						ans = ans + "R";
					}
				}
			}
			
			// 앞으로 무조건 직진
			ans = ans + "A";
			
			// visit 표시
			for (int j = 0; j < 2; j++) {
				x += DX[nextDir];
				y += DY[nextDir];
				map[x][y] = '.';
			}
			
			dir = nextDir;
			
//				System.out.println(ans + " ---------------- dir : " + nextDir);
//				for (int a = 0; a < map.length; a++) {
//					for (int b = 0; b < map[0].length; b++) {
//						System.out.print(map[a][b]);
//					}System.out.println();
//				}System.out.println();
			
		}
		
		System.out.println((start[0]+1) + " " + (start[1]+1));
		System.out.println(DIR[firstDir]);
		System.out.println(ans);
	}

	// 시작 지점 찾기 함수
	public static int[] findStart(char[][] map) {
		for (int i = 0 ; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == '#') {
					int nearby = 0;
					for (int k = 0; k < DX.length; k++) {
						if (inRange(i+DX[k], j+DY[k], map.length, map[i].length) && map[i+DX[k]][j+DY[k]] == '#') {
							nearby++;
						}
					}
					
					if (nearby == 1) {		// 주변에 '#'이 1개인 '#'의 위치 찾기 = 시작/끝 지점
						return new int[] {i, j};
					}
				}
			}
		}
		
		return new int[2];
	}
	
	// 좌표 범위 체크 함수
	public static boolean inRange(int x, int y, int maxX, int maxY) {
		if (x >= 0 && y >= 0 && x < maxX && y < maxY) {
			return true;
		} else {
			return false;
		}
	}
	
	// 다음 방향 찾기
	public static int findNextDir(char[][] map, int x, int y) {
		for (int i = 0; i < DX.length; i++) {
			if (inRange(x+DX[i], y+DY[i], map.length, map[0].length) && map[x+DX[i]][y+DY[i]] == '#') {
				return i;
			}
		}
		return -1;
	}
	
	// 전체 방문 여부 체크 함수
	public static boolean allVisit(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == '#') {
					return false;
				}
			}
		}
		
		return true;
	}
}

/*
(Intput)
5 8
#######.
........
........
........
........
(Outputs)
1 1
>
AAA
-- or --
1 7
<
AAA

(Intput)
9 14
.......###....
.........#....
.#####...###..
.#.........#..
.#.#####...###
.#.#...#.....#
.###.###.....#
.....#.......#
.....#########
(Outputs)
3 6
<
AALAALALARAARARALALAAAALAALARALARALA
-- or --
1 8
>
ARALARALARAARAAAARARALALAALARARAARAA
 */