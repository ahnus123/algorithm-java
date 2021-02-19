package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_1948_CriticalPath_Fail {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	// input
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] enter = new int[n+1];			// i 도시로 연결된 도로 개수
		int[] time = new int[n+1];			// 출발도시 ~ i 도시까지 최대 소요 시간
		int[] cntRoad = new int[n+1];		// 출발도시 ~ i 도시까지 거쳐야하는 최대 도시 개수
		ArrayList<int[]>[] road = new ArrayList[n+1];	// [출발도시 번호] 출발도시 번호, 도착도시 번호, 소요 시간
		
		for (int i = 0; i < n + 1; i++) {
			road[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			int[] r = new int[3];
			r[0] = sc.nextInt();
			r[1] = sc.nextInt();
			r[2] = sc.nextInt();
			road[r[0]].add(r);
			enter[r[1]]++;
		}
		int start = sc.nextInt();
		int end = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		
		q.add(start);
		
		while (q.isEmpty() == false) {
			printQueue(q);
			
			int now = q.poll();
			
			
			for (int i = 0; i < road[now].size(); i++) {
				int next = road[now].get(i)[1];
				if (time[now] + road[now].get(i)[2] > time[next]) {
					time[next] = time[now] + road[now].get(i)[2];		// i 도시까지 소요되는 최대 시간 업데이트
					cntRoad[next] = cntRoad[now] + 1;					// i 도시까지 거쳐야하는 도시 개수 업데이트
				} else if (time[now] + road[now].get(i)[2] == time[next]) {
					cntRoad[next] += cntRoad[now] + 1;
				}
				
				enter[next]--;
				
				if (enter[next] == 0 || now == start) {
					q.add(next);		// 큐에 다음 도시 추가
				}
			}
		}
		
		System.out.println(time[end] + "\n" + cntRoad[end]);
	}
	
	public static void printQueue(Queue<Integer> q) {
		int size = q.size();
		for(int i = 0;i<size;i++) {
			int temp = q.poll();
			System.out.print(temp + "\t");
			q.add(temp);
		}System.out.println("");
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

(Input)
4 4
1 2 5
1 3 4
3 2 3
2 4 1
1 4
(Outputs)
8
3

(Input)
4 4
1 2 2
1 3 3
1 4 2
2 3 1
1 4
(Outputs)
2
1

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
11
6
*/
