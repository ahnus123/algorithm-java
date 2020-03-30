package etc;

import java.util.ArrayList;
import java.util.List;

public class kakaoExam04 {
	public static void main(String[] args) {
		long k = 10;
		long[] room_number = {1,3,4,1,3,1};
		solution(k, room_number);
		//(output) [1,3,4,2,5,6]
	}
	
	public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        long[] room = new long[(int)k + 1];
        //List<Integer> room = new ArrayList<Integer>((int)k);
        
        for(int i=0;i<room_number.length;i++) {
        	long pick = room_number[i] - 1;
        	if(room[(int)pick] == 0) {		//원하는 방 == 빈 방
        		room[(int)pick] = 1;		//룸 채우고
        		answer[i] = pick + 1;		//정답에 룸번호 저장
        	} else {
        		for(int j=(int)pick+1;j<room.length;j++) {		//원하는 방 이후의 빈 방 찾기
        			if(room[j] == 0) {
        				room[j] = 1;
                		answer[i] = j + 1;
        				break;
        			}
        		}
        	}
        }
        
        for(int i=0;i<room.length;i++) {
        	System.out.print(room[i] + "\t");
        }System.out.println();
        
        for(int i=0;i<room_number.length;i++) {
        	System.out.print(answer[i] + "\t");
        }System.out.println();
        
        return answer;
    }
}
