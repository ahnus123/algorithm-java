package programmers;

import java.util.Stack;

public class programmers_43162_Networks {

	public static void main(String[] args) {
		int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		//solution(3, computers1);
		//(Outputs) 2
		
		int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		solution(3, computers2);
		//(Outputs) 1
	}
	
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        
        for(int i=0;i<computers.length;i++)
        	for(int j=0;j<computers[i].length;j++)
        		if(computers[i][j] == 1)
        			if(findNetwork(i, computers))	// 네트워크 찾기(BFS)
        				answer++;
        
        System.out.println(answer);
        return answer;
    }
    
    public static boolean findNetwork(int startCom, int[][] computers) {
    	boolean isFind = false;
    	Stack<Integer> netComputers = new Stack<Integer>();		// 연결된 컴퓨터 stack
    	
    	netComputers.add(startCom);
    	
    	while(!netComputers.isEmpty()) {	// 연결된 컴퓨터가 없을 때까지
    		int nCom = netComputers.pop();
    		
	    	for(int i=0;i<computers.length;i++) {	// 연결된 컴퓨터 연결 끊기 + 네트워크에 추가
	    		if(computers[nCom][i] == 1) {
	    			computers[nCom][i] = 0;
	    			computers[i][nCom] = 0;
	    			netComputers.add(i);
	    			isFind = true;
	    		}
	    	}
    	}
    	
//    	System.out.println("-------------------");		// print 네트워크 현황
//    	for(int i=0;i<computers.length;i++) {
//    		for(int j=0;j<computers[i].length;j++) {
//    			System.out.print(computers[i][j] + " ");
//    		}System.out.println();
//    	}System.out.println();
    	
    	return isFind;
    }
}
