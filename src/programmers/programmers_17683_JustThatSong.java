package programmers;

import java.lang.reflect.Array;
import java.util.Arrays;

public class programmers_17683_JustThatSong {

	public static void main(String[] args) {
		String[] musicinfos1 = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		//solution("ABCDEFG", musicinfos1);
		//(output) HELLO
		
		String[] musicinfos2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		//solution("CC#BCC#BCC#BCC#B", musicinfos2);
		//(output) FOO
		
		String[] musicinfos3 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		//solution("ABC", musicinfos3);
		//(output) WORLD
		
		String[] musicinfos4 = { "12:00,12:14,HELLO,A#B", "13:00,13:14,WORLD,A#B" };
		solution("A#B", musicinfos4);
		//(output) HELLO
	}

	public static String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxLength = -1;
        int[] length = new int[musicinfos.length];		//실제 플레이 시간
        String[] play = new String[musicinfos.length];		//플레이된 음악
        String[][] musicinfo = new String[musicinfos.length][];
        
        Arrays.sort(musicinfos);	//시간순으로 재생된 음악 정렬
        
        m = soundToHex(m);			// 음계 > 16진수로 변경
        for(int i=0;i<musicinfos.length;i++) {
        	musicinfo[i] = musicinfos[i].split(",");
        	length[i] = calTime(musicinfo[i][0], musicinfo[i][1]);
        	musicinfo[i][3] = soundToHex(musicinfo[i][3]);
        	play[i] = calPlay(length[i], musicinfo[i][3]);
        	//System.out.println(i + " : " + length[i] + " / " + musicinfo[i][3] + " >> " + play[i]);
        }
        
        for(int i=play.length-1;i>=0;i--) {			//튜브가 들은 음악과 일치하는 음악 찾기
        	if(play[i].contains(m)) {
        		System.out.println(i + " --" + play[i]);
        		if(maxLength <= length[i]) {
        			maxLength = length[i];
        			answer = musicinfo[i][2];
        		}
        	}
        }
        
        if(maxLength == -1)			//일치하는 음악 없음
        	answer = "(None)";
        
        System.out.println(answer);
        return answer;
    }
	
	public static int calTime(String startTime, String endTime) {		//재생시간 계산 함수
		String[] start = startTime.split(":");
		String[] end = endTime.split(":");
		int startInt = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
		int endInt = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
		
		//System.out.println(start[0] + ":" + start[1] + ", " + end[0] + ":" + end[1]);
		//System.out.println(startInt + ", " + endInt);
		return endInt-startInt;
	}
	
	//C, C#, D, D#, E, F, F#, G, G#, A, A#, B >> 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F 변환
	public static String soundToHex(String str) {
		String res = "";
        String[] sound = {"C", "C#", "D", "D#", "E", "E#", "F", "F#", "G", "G#", "A", "A#", "B"};
        String[] hex = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C"};
        
		for(int i=0;i<str.length()-1;i++) {
			String ch = "";
			if(str.charAt(i+1) == '#') {
				ch = str.charAt(i) + "" + str.charAt(i+1);
				i++;
			} else {
				ch = str.charAt(i) + "";
			}

			for(int j=0;j<sound.length;j++)
				if(String.valueOf(ch).equals(sound[j]))
					res = res + hex[j];
		}
		
		if(str.charAt(str.length()-1) != '#') {
			for(int j=0;j<sound.length;j++)
				if(String.valueOf(str.charAt(str.length()-1)).equals(sound[j]))
					res = res + hex[j];
		}
		
		return res;
	}
	
	public static String calPlay(int length, String music) {		//재생시간동안 재생된 음악 변환 함수
		String play = "";
		for(int i=0;i<length;i++)
			play = play + music.charAt(i%music.length());
		
		return play;
	}
}
