package baekjun;

import java.util.*;

public class baek_2667_ComplexNumbering {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] strMap = new String[N];
		int[][] map = new int[N][N];
		List<Integer> ans = new ArrayList<Integer>();
		
		for(int i=0;i<N;i++)				//input
			strMap[i] = sc.next();
		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				map[i][j] = (int)(strMap[i].charAt(j) - '0');
		
		int num = 2;
		for(int i=0;i<N;i++) {				//단지 찾기
			for(int j=0;j<N;j++) {
				if(map[i][j] == 1) {
					ans.add(findComplex(map, i, j, num));
					num++;
				}
			}
		}
					
		Collections.sort(ans);				//단지별 집 수 정렬
		
		for(int i=0;i<N;i++) {			//지도 출력
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j] + " ");
			}System.out.println();
		}
		
		System.out.println(num - 2);		//정답 출력
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}

	}
	
	//같은 단지인 집 찾기
	public static int findComplex(int[][] map, int x, int y, int num) {
		int res = 1;
		int[] dx = {-1, 0, 1, 0};			//4방향 이동
		int[] dy = {0, -1, 0, 1};
		
		map[x][y] = num;
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < map.length && ny < map.length) {
				if(map[nx][ny] == 1) {		//같은 단지면
					map[nx][ny] = num;
					res += findComplex(map, nx, ny, num);
				}
			}
		}
		
		return res;
	}
}

/*
(input)
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

(output)
3
7
8
9
 */
