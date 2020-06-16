package programmers;

import java.util.*;

public class programmers_17684_Compression {

	public static void main(String[] args) {
		String msg1 = "KAKAO";
		solution(msg1);
		//[11, 1, 27, 15]
		
		String msg2 = "TOBEORNOTTOBEORTOBEORNOT";
		solution(msg2);
		//[20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
		
		String msg3 = "ABABABABABABABAB";
		solution(msg3);
		//[1, 2, 27, 29, 28, 31, 30]
	}
	
	static public int[] solution(String msg) {
        int[] answer;
        List<String> dic = new ArrayList<String>();
        List<Integer> ans = new ArrayList<Integer>();
        
        for(int i=0;i<26;i++)			//사전에 알파벳 A~Z 넣기
        	dic.add((char)(65+i) + "");
        
        while(msg.length() > 0) {
        	String w = findW(dic, msg);		//사전에 있는 가장 긴 문자열 w 찾기
        	for(int i=0;i<dic.size();i++)
        		if(w.equals(dic.get(i)))
        			ans.add(i+1);
        	
        	String wc;
        	if(w.length() < msg.length())
        		wc = w + msg.charAt(w.length());
        	else
        		wc = "";
        	
        	for(int i=0;i<dic.size();i++)		//문자열 w+c가 사전에 없으면 추기
        		if(w.equals(dic.get(i)))
        			dic.add(wc);
        	
        	msg = msg.substring(w.length(), msg.length());		//문자열 msg 업데이트
        }
        
        answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++)
        	answer[i] = ans.get(i);

        /*for(int i=0;i<answer.length;i++) {			//정답 출력
        	System.out.print(answer[i] + "\t");
        }System.out.println();*/
        
        return answer;
    }
	
	static public String findW(List<String> dic, String subMsg) {		//사전에 있는 가장 긴 문자열 w 찾기
		String w = subMsg;
		
		for(int i=0;i<subMsg.length();i++) {
			for(int j=0;j<dic.size();j++) {
				if(w.equals(dic.get(j)))		//사전에 있는 w 찾으면
					return w;
			}

			w = w.substring(0, w.length() - 1);
		}
		
		return w;
	}

}
