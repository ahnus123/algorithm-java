package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_1948_CriticalPath_TimeFail {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	// input
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] enter = new int[n+1];
		int[] time = new int[n+1];
		int[] cntRoad = new int[n+1];
		ArrayList<int[]> road = new ArrayList<>();	// 출발 도시 번호, 도착 도시 번호, 소요 시간
		for (int i = 0; i < m; i++) {
			int[] r = new int[3];
			r[0] = sc.nextInt();
			r[1] = sc.nextInt();
			r[2] = sc.nextInt();
			road.add(r);
			enter[r[1]]++;
		}
		int start = sc.nextInt();
		int end = sc.nextInt();
		int ansTime = 0;
		int ansCntRoad = 0;
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 0; i < cntRoad.length; i++) {
			cntRoad[i] = 1;
		}
		
		q.add(start);
		
		while (q.isEmpty() == false) {
			int now = q.poll();
			enter[now]--;
			
			int size = road.size();
			for (int i = size - 1; i >= 0; i--) {
				if (road.get(i)[0] == now) {
					int next = road.get(i)[1];
					time[next] = Math.max(time[now] + road.get(i)[2], time[next]);	// i 도시까지 소요되는 최대 시간 업데이트
					cntRoad[next] = Math.max(cntRoad[now] + 1, cntRoad[next]);		// i 도시까지 거쳐야하는 최대 도시 개수 업데이트
					
					if (enter[now] == 0 || now == start) {
						road.remove(i);		// 방문한 도로 삭제
						q.add(next);		// 큐에 다음 도시 추가
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			ansTime = Math.max(time[i], ansTime);
			ansCntRoad = Math.max(cntRoad[i], ansCntRoad);
		}
		
		for (int i = 1; i <= n; i++) {
			System.out.print(time[i] + "\t");
		}System.out.println();
		for (int i = 1; i <= n; i++) {
			System.out.print(cntRoad[i] + "\t");
		}System.out.println();
		
		System.out.println(ansTime + "\n" + ansCntRoad);
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

