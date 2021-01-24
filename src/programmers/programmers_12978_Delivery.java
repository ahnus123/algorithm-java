package programmers;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
	int to, time;
	
	public Node(int to, int time) {
		this.to = to;
		this.time = time;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.time - o.time;
	}
}

public class programmers_12978_Delivery {

	public static void main(String[] args) {
		int[][] road1 = {{1,2,1}, {2,3,3}, {5,2,2}, {1,4,2}, {5,3,1}, {5,4,2}};
		solution(5, road1, 3);
		//(Outputs) 4

		int[][] road2 = {{1,2,1}, {1,3,2}, {2,3,2}, {3,4,3}, {3,5,2}, {3,5,3}, {5,6,1}};
		solution(6, road2, 4);
		//(Outputs) 4
	}

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] dist = new int[N];
        int[] visit = new int[N];
        ArrayList<ArrayList<Node>> arr = new ArrayList<>();
        
        for(int i=0;i<N;i++)
        	arr.add(new ArrayList<>());
        for(int i=0;i<N;i++)
        	dist[i] = Integer.MAX_VALUE;
        
        for(int i=0;i<road.length;i++) {
        	int first = road[i][0]-1;
        	int second = road[i][1]-1;
        	
        	arr.get(first).add(new Node(second, road[i][2]));
        	arr.get(second).add(new Node(first, road[i][2]));
        }
        
        dijkstra(arr, dist, visit, 0);
        
        for(int i=0;i<N;i++)
        	if(dist[i] <= K)
        		answer++;
        
        System.out.println(answer);
        return answer;
    }
    
    public static void dijkstra(ArrayList<ArrayList<Node>> arr, int[] dist, int[] visit, int start) {
    	dist[start] = 0;
    	Node sNode = new Node(start, 0);
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.add(sNode);
    	
    	while(!pq.isEmpty()) {
    		Node now = pq.poll();
    		if(visit[now.to] == 1) {
    			continue;
    		} else {
    			visit[now.to] = 1;
    			ArrayList<Node> nList = arr.get(now.to);
    			
    			for(int i=0;i<nList.size();i++) {
    				Node next = nList.get(i);
    				if(dist[next.to] > dist[now.to] + next.time) {
    					dist[next.to] = dist[now.to] + next.time;
    					pq.add(new Node(next.to, dist[next.to]));
    				}
    			}
    		}
    	}
    }
}
