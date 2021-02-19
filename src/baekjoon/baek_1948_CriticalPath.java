package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_1948_CriticalPath {
	public static int cntRoad = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	// input
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] enter = new int[n+1];			// i 도시로 연결된 도로 개수
		int[] time = new int[n+1];			// 출발도시 ~ i 도시까지 최대 소요 시간
		ArrayList<int[]>[] road = new ArrayList[n+1];	// [출발도시 번호] 출발도시 번호, 도착도시 번호, 소요 시간
		ArrayList<int[]>[] reverse = new ArrayList[n+1];	// [도착도시 번호] 출발도시 번호, 도착도시 번호, 소요 시간
		
		for (int i = 0; i < n + 1; i++) {
			road[i] = new ArrayList<>();
			reverse[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			int[] r = new int[3];
			r[0] = sc.nextInt();
			r[1] = sc.nextInt();
			r[2] = sc.nextInt();
			road[r[0]].add(r);
			reverse[r[1]].add(r);
			enter[r[1]]++;
		}
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		maxTime(road, time, enter, start, end);		// 도착도시까지 최대 소요시간 구하기

		int[] visit = new int[n+1];
		countRoad(reverse, visit, time, start, end);		// 도로 개수 카운드(dfs)
		
		System.out.println(time[end] + " " + cntRoad);
	}
	
	public static void maxTime(ArrayList<int[]>[] road, int[] time, int[] enter, int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(start);
		
		while (q.isEmpty() == false) {
			int now = q.poll();
			
			for (int i = 0; i < road[now].size(); i++) {
				int next = road[now].get(i)[1];
				time[next] = Math.max(time[now] + road[now].get(i)[2], time[next]);	// i 도시까지 소요되는 최대 시간 업데이트
				
				enter[next]--;
				
				if (enter[next] == 0) {
					q.add(next);		// 큐에 다음 도시 추가
				}
			}
		}
	}
	
	public static void countRoad(ArrayList<int[]>[] reverse, int[] visit, int[] time, int start, int now) {
		if (visit[now] == 1) {
			return;
		} else {
			visit[now] = 1;
		}
		
		for (int i = 0; i < reverse[now].size(); i++) {
			int next = reverse[now].get(i)[0];
			if (time[now] - reverse[now].get(i)[2] == time[next]) {
				cntRoad++;
				countRoad(reverse, visit, time, start, next);
			}
		}
	}
	
	/*public static void printQueue(Queue<Integer> q) {
		int size = q.size();
		for(int i = 0;i<size;i++) {
			int temp = q.poll();
			System.out.print(temp + "\t");
			q.add(temp);
		}System.out.println("");
	}*/

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
12 5

(Input)
4 4
1 2 5
1 3 4
3 2 3
2 4 1
1 4
(Outputs)
8 3

(Input)
4 4
1 2 2
1 3 3
1 4 2
2 3 1
1 4
(Outputs)
2 1

(Input)
7 7
1 2 4
1 3 2
3 4 1
4 5 3
5 6 1
6 2 2
2 7 2
1 7
(Outputs)
11 6
*/
