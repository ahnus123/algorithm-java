package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class programmers_64064_BadUser {
	public static ArrayList<ArrayList<String>> ansList = new ArrayList<>();

	public static void main(String[] args) {
		String[] user_id1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id1 = {"fr*d*", "abc1**"};
		//solution(user_id1, banned_id1);
		//(Outputs) 

		String[] user_id2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id2 = {"*rodo", "*rodo", "******"};
		solution(user_id2, banned_id2);
		//(Outputs) 

		String[] user_id3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id3 = {"fr*d*", "*rodo", "******", "******"};
		//solution(user_id3, banned_id3);
		//(Outputs) 
	}

    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        ArrayList<ArrayList<String>> banIdList = new ArrayList<>();
        
        for(int i=0;i<banned_id.length;i++) {		// 제재 아이디 리스트 구하기
        	ArrayList<String> banId = findBanID(user_id, banned_id[i]);
        	banIdList.add(banId);
        }
        
        ArrayList<String> list = new ArrayList<>();
        countList(banIdList, list, 0);		// 제재 아이디 목록 가지 수 구하기
        
	    for(int i=0;i<ansList.size()-1;i++) {		// 중복되는 정답 삭제
	    	for(int j=i+1;j<ansList.size();j++) {
	    		if(ansList.get(i).size() != ansList.get(j).size())
	    			break;
	    		
	    		for(int k=0;k<ansList.get(i).size();k++) {
	    			if(!ansList.get(i).get(k).equals(ansList.get(j).get(k))) {
	    				break;
	    			} else if(k == ansList.get(i).size() - 1) {
	    				ansList.remove(j);
	    				j--;
	    			}
	    		}
	    	}
	    }
        
//        for(int i=0;i<ansList.size();i++) {		// 정답 출력
//        	for(String str : ansList.get(i)) {
//        		System.out.print(str + "\t");
//        	}System.out.println();
//        }
        
	    answer = ansList.size();
	    System.out.println(answer);
	    
        return answer;
    }
    
    // 제재 아이디 리스트 구하기
    public static ArrayList<String> findBanID(String[] user_id, String banned) {
    	ArrayList<String> banList = new ArrayList<>();
    	
    	for(String user : user_id) {
    		boolean isMatch = true;
    		if(user.length() != banned.length())
    			continue;
    		
    		for(int i=0;i<user.length();i++) {
    			if(user.charAt(i) != banned.charAt(i) && banned.charAt(i) != '*') {
    				isMatch = false;
    				break;
    			}
    		}
    		
    		if(isMatch)
    			banList.add(user);
    	}
    	
    	return banList;
    }
    
    // 제재 아이디 목록 가지 수 구하기
    public static void countList(ArrayList<ArrayList<String>> banIdList, ArrayList<String> list, int idx) {
    	if(list.size() == banIdList.size()) {
    		Collections.sort(list);
    		ansList.add(list);
    		return;
    	}
    	
    	for(int i=0;i<banIdList.get(idx).size();i++) {
    		if(!list.contains(banIdList.get(idx).get(i))) {
    			ArrayList<String> copyList = copySet(list);
    			copyList.add(banIdList.get(idx).get(i));
    			countList(banIdList, copyList, idx+1);
    		}
    	}
    }
    
    public static ArrayList<String> copySet(ArrayList<String> ori) {	// ArrayList 복사 함수
    	ArrayList<String> copy = new ArrayList<>();
    	for(String str : ori)
    		copy.add(str);
    	return copy;
    }
}
