package etc;

import java.util.*;

public class kakaoExam01 {

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		solution(board, moves);
	}

	public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Queue<Integer> box = new LinkedList<Integer>();
        for(int i=0;i<moves.length;i++) {
        	int idx = moves[i] - 1;
        	
        	for(int j=0;j<board.length;j++) {
        		if(board[j][idx] != 0) {
                	box.add(board[j][idx]);
                	board[j][idx] = 0;
        			break;
        		}
        	}
        }
        
        int bsize = box.size();
		for(int i=0;i<bsize;i++) {
			int n = box.poll();
			System.out.print(n + "\t");
			box.add(n);
		}System.out.println();
		System.out.println();
        
        answer = removeDolls(box);
        System.out.println("answer : " + answer);
        
        return answer;
    }
	
	public static int removeDolls(Queue<Integer> box) {
		boolean remove = true;
		int size = box.size();
		int removeCount = 0;
		
		System.out.println(box.size());
		
		while(remove) {
			if(box.isEmpty())
				break;
			
			int before = box.poll();
			remove = false;
			Queue<Integer> newBox = new LinkedList<Integer>();
			
			while(!box.isEmpty()) {
				int now = box.poll();
				
				if(before == now) {
					removeCount += 2;
					remove = true;
					before = -1;
				} else {
					if(before != -1)
						newBox.add(before);
					before = now;
					
					if(box.size() == 0)
						newBox.add(now);
				}
			}
			
			/*int bsize = newBox.size();
			for(int i=0;i<bsize;i++) {
				int n = newBox.poll();
				System.out.print(n + "\t");
				newBox.add(n);
			}System.out.println();*/

			box = newBox;
		}
		
		return removeCount;
	}
}
