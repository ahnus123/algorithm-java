package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Path {
	int city;
	int time;
	int cntCity;
	
	public Path(int city, int time, int cntCity) {
		this.city = city;
		this.time = time;
		this.cntCity = cntCity;
	}
}

public class baek_1948_CriticalPath_MemoryFail {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	// input
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] road = new int[n+1][n+1];
		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int t = sc.nextInt();
			road[s][e] = t;
		}
		int start = sc.nextInt();
		int end = sc.nextInt();
		int ansTime = 0;
		int ansRoad = 0;
		Queue<Path> q = new LinkedList<>();
		
		Path p = new Path(start, 0, 1);
		q.add(p);
		
		while (q.isEmpty() == false) {
			Path now = q.poll();
			int nowCity = now.city;
			int nowTime = now.time;
			int nowCntCity = now.cntCity;
			
			//System.out.println(nowCity + ", " + nowTime + ", " + nowCntCity);
			
			if (nowCity == end) {		// 도착지에 도착
				ansTime = Math.max(nowTime, ansTime);		// 최대 소요 시간
				ansRoad = Math.max(nowCntCity, ansRoad);	// 최대 도시 개수
				continue;
			}
			
			for (int i = 1; i <= n; i++) {
				if (road[nowCity][i] > 0) {		// 도로가 있으면
					Path next = new Path(i, nowTime + road[nowCity][i], nowCntCity + 1);
					q.add(next);				// 다음 도시 추가
				}
			}
		}
		
		System.out.println(ansTime);
		System.out.println(ansRoad);
	}

}

/* 
(input)
7
9
1 2 4
1 3 2
1 4 3
2 6 3
2 7 5
3 5 1
4 6 4
5 6 2
6 7 5
1 7
(Outputs)
5
*/

