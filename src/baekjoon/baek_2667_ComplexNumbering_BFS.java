package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import javafx.util.Pair;

public class baek_2667_ComplexNumbering_BFS {

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
		
		int groupNum = 0;
		for(int i=0;i<N;i++) {				//단지 찾기
			for(int j=0;j<N;j++) {
				if(map[i][j] == 1) {
					int count = 0;
					groupNum++;				//단지 수 + 1
					Queue<Pair<Integer, Integer>> group = new LinkedList<Pair<Integer, Integer>>();
					
					map[i][j] = -1;
					group.add(new Pair<>(i, j));
					while(!group.isEmpty()) {
						int[] dx = {-1, 0, 1, 0};
						int[] dy = {0, -1, 0, 1};
						Pair<Integer, Integer> now = group.element();	//현재 좌표
						group.remove();									//현재 좌표 삭제
						count++;							//이번 단지 집 수 + 1
						
						for(int k=0;k<4;k++) {				//4방향으로 이동
							int nx = now.getKey() + dx[k];
							int ny = now.getValue() + dy[k];
							if(nx >=0 && ny >= 0 && nx < N && ny < N) {
								if(map[nx][ny] == 1) {		//같은 단지면
									map[nx][ny] = -1;		//방문으로 체크
									group.add(new Pair<>(nx, ny));
								}
							}
						}
					}
					ans.add(count);
				}
			}
		}
				
		Collections.sort(ans);				//단지별 집 수 정렬
		
		/*for(int i=0;i<N;i++) {			//지도 출력
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j] + " ");
			}System.out.println();
		}*/
		
		System.out.println(groupNum);		//정답 출력
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}

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
