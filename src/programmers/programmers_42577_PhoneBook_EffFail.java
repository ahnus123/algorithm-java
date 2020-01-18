package programmers;

import java.util.HashSet;
import java.util.Iterator;

public class programmers_42577_PhoneBook_EffFail {
	public static void main(String[] args) {
		programmers_42577_PhoneBook_EffFail m = new programmers_42577_PhoneBook_EffFail();
		
		//String[] phone = {"119", "97674223", "1195524421"};
		String[] phone = {"123","456","789"};
		//String[] phone = {"12","123","1235","567","88"};
		
		m.solution(phone);
	}

	public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> phone = new HashSet<>();
        
        for(int i=0;i<phone_book.length;i++)		//HashSet에 전화번호 저장
        	phone.add(phone_book[i]);
        
        for(int i=0;i<phone_book.length;i++) {
        	Iterator<String> it = phone.iterator();
        	while(it.hasNext()) {
        		String ph = it.next();
        		if(phone_book[i].indexOf(ph) == 0 && !phone_book[i].contentEquals(ph)) {
        			answer = false;
        		}
        	}
        }
        
        System.out.println(answer);
        
        return answer;
    }
}
