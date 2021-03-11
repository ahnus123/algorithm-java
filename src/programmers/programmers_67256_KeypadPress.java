package programmers;

public class programmers_67256_KeypadPress {

	public static void main(String[] args) {
		int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String ans1 = solution(numbers1, "right");
		System.out.println(ans1);
		//(Outputs) "LRLLLRLLRRL"
		
		int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String ans2 = solution(numbers2, "left");
		System.out.println(ans2);
		//(Outputs) "LRLLRRLLLRR"

		int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		String ans3 = solution(numbers3, "right");
		System.out.println(ans3);
		//(Outputs) "LLRLLRLLRL"
	}
	
	/*
	 1 2 3
	 4 5 6
	 7 8 9
	 * 0 #
	 */
	public static String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] hands = new int[2][2];		// [0] : 왼손 좌표 / [1] : 오른손 좌표
        hands[0][0] = 3;	hands[0][1] = 0;
        hands[1][0] = 3;	hands[1][1] = 2;
        
        for (int i = 0; i < numbers.length; i++) {
        	if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {			// 키패드 1, 4, 7
        		answer = pressKeypad(hands, numbers[i], "L", answer);
        	} else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {		// 키패드 3, 6, 9
        		answer = pressKeypad(hands, numbers[i], "R", answer);
        	} else {		// 키패드 2, 5, 8
        		if (numbers[i] == 0) {
        			numbers[i] = 11;
        		}

        		int[] num = {(numbers[i] - 1) / 3, (numbers[i] - 1) % 3}; 
        		int leftDiff = Math.abs(hands[0][0] - num[0]) + Math.abs(hands[0][1] - num[1]);
        		int rightDiff = Math.abs(hands[1][0] - num[0]) + Math.abs(hands[1][1] - num[1]);
        		
        		System.out.println(leftDiff + " <-> " + rightDiff);
        		System.out.println("left : " + (hands[0][0]*3 + hands[0][1]+1) + " / right : " + (hands[1][0]*3 + hands[1][1]+1) + " / number : " + numbers[i]);
        		
        		if (leftDiff == rightDiff) {			// 왼손 거리 = 오른손 거리
        			if (hand.equals("left")) {
        				answer = pressKeypad(hands, numbers[i], "L", answer);
        			} else if (hand.equals("right")) {
        				answer = pressKeypad(hands, numbers[i], "R", answer);
        			}
        		} else if (leftDiff < rightDiff) {		// 왼손 거리 > 오른손 거리
        			answer = pressKeypad(hands, numbers[i], "L", answer);
        		} else {								// 왼손 거리 < 오른손 거리
        			answer = pressKeypad(hands, numbers[i], "R", answer);
        		}
        	}
        }
        
        return answer;
    }
	
	// 키보드 누르기 함수
	public static String pressKeypad(int[][] hands, int number, String dir, String answer) {
		if (dir.equals("L")) {
			hands[0][0] = (number - 1) / 3;
			hands[0][1] = (number - 1) % 3;
		} else if (dir.equals("R")) {
			hands[1][0] = (number - 1) / 3;
			hands[1][1] = (number - 1) % 3;
		}
		
		return answer + dir;
	}
}
