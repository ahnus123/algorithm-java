package programmers;

import java.util.ArrayList;

public class programmers_12952_NQueen_TimeFail {
	public static int ANS = 0;

	public static void main(String[] args) {
		solution(4);
		//(Outputs) 2
	}

    public static int solution(int n) {
        int answer = 0;
        
        ArrayList<Integer> arr = new ArrayList<>();
        rePermutation(arr, n, n);
        
        answer = ANS;
        System.out.println(answer);
        
        return answer;
    }
    
    public static void rePermutation(ArrayList<Integer> arr, int n, int r) {
    	if(arr.size() == r) {
    		int[][] map = new int[n][n];
    		
    		for (int i = 0; i < arr.size(); i++) {		// 각 열마다 queen 배치
    			map[i][arr.get(i)] = 1;
    		}
    		
    		if(checkCondition(map, arr) == true) {	// 모든 queen이 조건을 만족하면 정답+1
        		//printMap(map);
    			//System.out.println("!!!!!!!!!!!!");
    			ANS++;
    		}
    		
    		return;
    	}
    	
    	for (int i = 0; i < n; i++) {
    		arr.add(i);
    		rePermutation(arr, n, r);
    		arr.remove(arr.size()-1);
    	}
    }
    
    public static boolean checkCondition(int[][] map, ArrayList<Integer> arr) {
    	for (int i = 0; i < arr.size(); i++) {
    		// i행의 queen 위치 : map[i][arr.get(i)]
    		for (int j = 0; j < map.length; j++) {		// 가로 확인
    			if (j == arr.get(i)) {
    				continue;
    			} else if (map[i][j] == 1) {
    				return false;
    			}
    		}
    		
    		int x = i;
    		int y = arr.get(i);
    		int move = 1;
    		while(x - move >= 0) {		// 위쪽 대각선
    			if(inRange(x - move, y, map.length, map.length) && map[x - move][y] == 1) {		// 위쪽 세로
    				return false;
    			}
    			if(inRange(x - move, y - move, map.length, map.length) && map[x - move][y - move] == 1) {	// 위쪽 + 왼쪽 대각선
    				return false;
    			}
    			if(inRange(x - move, y + move, map.length, map.length) && map[x - move][y + move] == 1) {	// 위쪽 + 오른쪽 대각선
    				return false;
    			}
    			move++;
    		}
    		
    		x = i;
    		y = arr.get(i);
    		move = 1;
    		while(x + move < map.length) {
    			if(inRange(x + move, y, map.length, map.length) && map[x + move][y] == 1) {		// 아래쪽 세로
    				return false;
    			}
    			if(inRange(x + move, y - move, map.length, map.length) && map[x + move][y - move] == 1) {	// 아래쪽 + 왼쪽 대각선
    				return false;
    			}
    			if(inRange(x + move, y + move, map.length, map.length) && map[x + move][y + move] == 1) {	// 아래쪽 + 오른쪽 대각선
    				return false;
    			}
    			move++;
    		}
    	}
    	
    	return true;
    }
    
    public static boolean inRange(int x, int y, int maxX, int maxY) {
    	if (x >= 0 && y >= 0 && x < maxX && y < maxY) {
    		return true;
    	}
    	
    	return false;
    }
    
    public static void printMap(int[][] map) {
    	for (int i = 0; i < map.length; i++) {
    		for (int j = 0; j < map[i].length; j++) {
    			System.out.print(map[i][j] + "\t");
    		}System.out.println();
    	}System.out.println();
    }
}
