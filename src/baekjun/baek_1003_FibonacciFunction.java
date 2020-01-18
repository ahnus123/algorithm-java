package baekjun;

import java.util.*;

public class baek_1003_FibonacciFunction {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] zero = new int[41];
		int[] one = new int[41];
		ArrayList<Integer> ans_zero = new ArrayList<Integer>();
		ArrayList<Integer> ans_one = new ArrayList<Integer>();
		
		zero[0] = 1;
		zero[1] = 0;
		one[0] = 0;
		one[1] = 1;
		
		for(int i=2;i<=40;i++) {				//~fibonacci(40) 0, 1 개수 저장
			zero[i] = zero[i - 1] + zero[i - 2];
			one[i] = one[i - 1] + one[i - 2];
		}
		
		for(int i=0;i<T;i++) {				//finonacci(N)의 0, 1 개수 ans배열에 저장
			int N = sc.nextInt();
			
			ans_zero.add(zero[N]);
			ans_one.add(one[N]);
		}
		
		for(int i=0;i<T;i++)				//정답 출력
			System.out.println(ans_zero.get(i) + " " + ans_one.get(i));
	}
	
	public int fibonacci(int n) {
		if(n == 0) {
			System.out.println("0");
			return 0;
		} else if(n == 1) {
			System.out.println("1");
			return 1;
		} else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
}

/*
(input)
3
0
1
3
(output)
1 0
0 1
1 2
*/