package baekjoon;

import java.util.Scanner;

public class baek_2753_LeapYear {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		
		int year = sc.nextInt();
		int answer = isLeapYear(year);
		
		System.out.println(answer);
		return;
	}

	public static int isLeapYear(int year) {
		if (year % 400 == 0) {
			return 1;
		} else if (year % 100 == 0) {
			return 0;
		} else if (year % 4 == 0) {
			return 1;
		}
		
		return 0;
	}
}
/*
 (intput)
 2000
 (outputs)
 1
 
 (input)
 1999
 (outputs)
 0
 */