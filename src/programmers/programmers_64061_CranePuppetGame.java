package programmers;

import java.util.ArrayList;

public class programmers_64061_CranePuppetGame {

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		solution(board, moves);
		// (Outputs) 4
	}

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> basket = new ArrayList<>();
        
        for (int i = 0; i < moves.length; i++) {
        	int line = moves[i] - 1;
        	
        	// 맨 위 인형 뽑기
        	int j = 0;
        	while (board[j][line] == 0) {
        		j++;
        		
        		if (j == board.length) {
        			break;
        		}
        	}

    		// 바구니에 인형 담기 + 인형 터트리기
        	if (j < board.length) {
	    		basket.add(board[j][line]);
	    		board[j][line] = 0;
	    		
	    		if (basket.size() > 1 && basket.get(basket.size()-2) == basket.get(basket.size()-1)) {
	    			answer += 2;
	    			basket.remove(basket.size()-1);
	    			basket.remove(basket.size()-1);
	    		}
        	}
        }
        
        System.out.println("answer : " + answer);
        return answer;
    }
}
