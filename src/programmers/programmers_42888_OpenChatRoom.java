package programmers;

import java.util.*;

public class programmers_42888_OpenChatRoom {

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", 
							"Enter uid4567 Prodo",
							"Leave uid1234",
							"Enter uid1234 Prodo",
							"Change uid4567 Ryan"};
		/* (output)
		 * ["Prodo님이 들어왔습니다.",
		 * "Ryan님이 들어왔습니다.",
		 * "Prodo님이 나갔습니다.",
		 * "Prodo님이 들어왔습니다."] */
		
		solution(record);
	}

	public static String[] solution(String[] record) {
        int size = 0, idx = 0;
        String[] answer;
        Map<String, String> nickList = new HashMap<String, String>();	//<아이디, 닉네임>
        String[][] strList = new String[record.length][];				//Enter/uid1234/Muzi

        for(int i=0;i<record.length;i++) {
            String[] split = record[i].split(" ");	//띄어쓰기를 기준으로 문자열 자르기
            strList[i] = split;

            if(split[0].equals("Enter")) {
                size++;
                nickList.put(split[1], split[2]);	//닉네임  업데이트
            } else if(split[0].equals("Leave")) {
                size++;
            } else if(split[0].equals("Change")) {
                nickList.put(split[1], split[2]);
            }
        }

        answer = new String[size];

        for(int i=0;i<strList.length;i++) {
            String str = "";				//정답 문자열
            String[] temp = strList[i];

            String nick = nickList.get(temp[1]);		//"(닉네임)님이"
            str = nick + "님이 ";

            if(temp[0].equals("Enter")) {				//"들어왔습니다."
                str = str + "들어왔습니다.";
                answer[idx] = str;
                idx++;
            } else if(temp[0].equals("Leave")) {		//"나갔습니다."
                str = str + "나갔습니다.";
                answer[idx] = str;
                idx++;
            }
        }

        return answer;
    }
}
