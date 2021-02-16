package baekjoon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class baek_14502_Laboratory {
	static int m, n, ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();
		n = sc.nextInt();
		int map[][] = new int[m][n];
		Queue<HashMap<Integer, Integer>> virus = new LinkedList<HashMap<Integer, Integer>>();
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) {
					HashMap<Integer, Integer> now = new HashMap<>();
					now.put(i, j);
					virus.add(now);
				}
			}
		}
		
		for(int i=0;i<m;i++) {		//벽 1개 세우기
			for(int j=0;j<n;j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					addWall(1, i, j, map, virus);
					map[i][j] = 0;
				}				
			}
		}
		
		System.out.println(ans);
		
		return;
	}
	
	//벽 추가하기
	public static void addWall(int wallCnt, int x, int y, int[][] map, Queue<HashMap<Integer, Integer>> virus) {
		if(wallCnt == 3) {		//벽 3개 세우기 완료
			int res = spreadVirus(map, virus);
			if(res > ans)		//최대 빈 칸 수 업데이트
				ans = res;
			
			/*for(int i=0;i<m;i++) {		//print
				for(int j=0;j<n;j++) {
					System.out.print(map[i][j] + " ");
				}System.out.println();
			}System.out.println();
			System.out.println(virus.size());*/
			
			return;
		}
		
		for(int i=0;i<m;i++) {		//벽 2개/3개 새우기
			for(int j=0;j<n;j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					addWall(wallCnt+1, i, j, map, virus);
					map[i][j] = 0;
				}				
			}
		}
	}

	//바이러스 퍼트리기
	public static int spreadVirus(int[][] originMap, Queue<HashMap<Integer, Integer>> originVirus) {
		int zeroCnt = 0;
		
		int[][] map = new int[originMap.length][originMap[0].length];		//배열, 큐 복사
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				map[i][j] = originMap[i][j];
		Queue<HashMap<Integer, Integer>> virus = new LinkedList<HashMap<Integer, Integer>>();
		for(int i=0;i<originVirus.size();i++) {
			HashMap<Integer, Integer> temp = originVirus.poll();
			virus.add(temp);
			originVirus.add(temp);
		}
		
		while(!virus.isEmpty()) {
			int dx[] = {-1, 0, 1, 0};
			int dy[] = {0, 1, 0, -1};
			HashMap<Integer, Integer> now = virus.poll();
			
			for(int i=0;i<4;i++) {		//4방향 체크
				for(int key : now.keySet()) {
					int nx = key + dx[i];
					int ny = now.get(key) + dy[i];

					if(nx >= 0 && ny >= 0 && nx < m && ny < n) {
						if(map[nx][ny] == 0) {		//바이러스 퍼트리기(추가)
							map[nx][ny] = 2;
							
							HashMap<Integer, Integer> nv = new HashMap<>();
							nv.put(nx, ny);
							virus.add(nv);
						}
					}
				}
			}
		}
		
		for(int i=0;i<m;i++)		//빈 칸 개수 카운트
			for(int j=0;j<n;j++)
				if(map[i][j] == 0)
					zeroCnt++;
		
		return zeroCnt;
	}
}
