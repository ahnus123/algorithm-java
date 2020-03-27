package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class programmers_17678_ShuttleBus {

	public static void main(String[] args) {
		int n1 = 1;		int t1 = 1;		int m1 = 5;
		String[] timetable1 = {"08:00", "08:01", "08:02", "08:03"};
		solution(n1, t1, m1, timetable1);
		//(output) 09:00
		
		int n2 = 2;		int t2 = 10;		int m2 = 2;
		String[] timetable2 = {"09:10", "09:09", "08:00"};
		solution(n2, t2, m2, timetable2);
		//(output) 09:09
		
		int n3 = 2;		int t3 = 1;		int m3 = 2;
		String[] timetable3 = {"09:00", "09:00", "09:00", "09:00"};
		solution(n3, t3, m3, timetable3);
		//(output) 08:59
		
		int n4 = 1;		int t4 = 1;		int m4 = 5;
		String[] timetable4 = {"00:01", "00:01", "00:01", "00:01", "00:01"};
		solution(n4, t4, m4, timetable4);
		//(output) 00:00
		
		int n5 = 1;		int t5 = 1;		int m5 = 1;
		String[] timetable5 = {"23:59"};
		solution(n5, t5, m5, timetable5);
		//(output) 09:00
		
		int n6 = 10;		int t6 = 60;		int m6 = 45;
		String[] timetable6 = {"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", 
				"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
		solution(n6, t6, m6, timetable6);
		//(output) 18:00
	}
	
	public static String solution(int n, int t, int m, String[] timetable) {
		String answer = "";
		int endBus = 540 + (n - 1) * t;
		int[][] bus = new int[n][m];
		Queue<Integer> crew = new LinkedList<Integer>();
		
		Arrays.sort(timetable);
		
		for(int i=0;i<timetable.length;i++) {			//"09:00" > 9*60 + 0 (=540)
			String[] splitTime = timetable[i].split(":");
			crew.add(Integer.parseInt(splitTime[0])*60 + Integer.parseInt(splitTime[1]));
		}
		
		for(int i=0;i<n;i++) {							//전체 크루 버스에 태우기
			for(int j=0;j<m;j++) {
				if(!crew.isEmpty()) {
					if(crew.peek() <= 540 + (i * t)) {
						int lastCrew = crew.poll();
						bus[i][j] = lastCrew;
					}
				}
			}
		}
		
		for(int i=0;i<m;i++) {
			if(bus[n-1][i] == 0) {			//막차에 자리가 남으면 > 막차시간
				answer = strTime(endBus);
			} else if(i == m - 1){						//막차에 자리가 다 차면 > (마지막사람 - 1)분
				answer = strTime(bus[n-1][i] - 1);
			}
		}
		
		/*for(int i=0;i<n;i++) {			//버스 자리 출력
			for(int j=0;j<m;j++) {
				System.out.print(bus[i][j] + " ");
			}System.out.println();
		}System.out.println();*/
		
		System.out.println("answer : " + answer);
		
		return answer;
	}
	
	public static String strTime(int time) {		//540 > "09:00"
		String strTime = "";
		int hour = time / 60;
		int minute = time % 60;
		
		if(hour >= 0 && hour <= 9)
			strTime = strTime + "0" + Integer.toString(hour) + ":";
		else
			strTime = strTime + Integer.toString(hour) + ":";
		
		if(minute >= 0 && minute <= 9)
			strTime = strTime + "0" + Integer.toString(minute);
		else
			strTime = strTime + Integer.toString(minute);
		
		return strTime;
	}

}
