package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class programmers_49189_FarthestNode {

	public static void main(String[] args) {
		int[][] edge1 = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		solution(6, edge1);
		//(output) 3
	}

	public static int solution(int n, int[][] edge) {
        int answer = 0;
        int maxCnt = -1;
        boolean[][] edges = new boolean[n][n];
        
        for(int i=0;i<edge.length;i++) {
        	edges[edge[i][0]-1][edge[i][1]-1] = true;
        	edges[edge[i][1]-1][edge[i][0]-1] = true;
        }
        
        /*for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		System.out.print(edges[i][j] + " ");
        	}System.out.println();
        }System.out.println();*/
        
    	int[] dis = new int[n];
    	boolean[] visited = new boolean[n];
    	Queue<Integer> nodes = new LinkedList<>();
        nodes.add(0);
        visited[0] = true;
        
        while(!nodes.isEmpty()) {
        	int now = nodes.poll();
        	
        	for(int i=1;i<n;i++) {		//1번 ~ n번 노드 거리 계산
        		if(edges[now][i] && !visited[i]) {
        			nodes.add(i);
        			visited[i] = true;
        			dis[i] = dis[now] + 1;
        		}
        	}
        }
        
        /*for(int i=0;i<n;i++)
        	System.out.print(cntEdges[i]);
        System.out.println();*/
        
        for(int i=0;i<n;i++) {		//가장 먼 노드 개수 카운트
        	if(dis[i] == maxCnt) {
        		answer++;
        	} else if(dis[i] > maxCnt) {
        		maxCnt = dis[i];
        		answer = 1;
        	}
        }
        
        System.out.println(answer);
        return answer;
    }
}
