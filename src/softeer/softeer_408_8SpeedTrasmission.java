package softeer;

import java.util.Scanner;

public class softeer_408_8SpeedTrasmission {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String answer = "";
		int[] numbers = new int[8];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}
		
		boolean isAscending = false;
		boolean isDescending = false;
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] < numbers[i+1]) {		// ascending
				isAscending = true;
			} else if (numbers[i] > numbers[i+1]) {	// descending
				isDescending = true;
			}
		}
		
		if (isAscending == true && isDescending == true) {
			answer = "mixed";
		} else if (isAscending == true) {
			answer = "ascending";
		} else if (isDescending == true) {
			answer = "descending";
		}
		
		System.out.println(answer);
	}

}

/*
(Input)
1 2 3 4 5 6 7 8
(Outputs)
ascending

(Input)
1 3 5 7 8 6 4 2
(Outputs)
mixed
 */