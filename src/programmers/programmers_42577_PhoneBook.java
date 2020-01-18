package programmers;

import java.util.HashSet;
import java.util.Iterator;

public class programmers_42577_PhoneBook {
	public static void main(String[] args) {
		programmers_42577_PhoneBook m = new programmers_42577_PhoneBook();
		
		//String[] phone = {"119", "97674223", "1195524421"};
		String[] phone = {"123","456","789"};
		//String[] phone = {"12","123","1235","567","88"};
		
		m.solution(phone);
	}

	public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        for(int i=0;i<phone_book.length - 1;i++) {
        	for(int j=i+1;j<phone_book.length;j++) {
        		if(phone_book[i].indexOf(phone_book[j]) == 0 || phone_book[j].indexOf(phone_book[i]) == 0) {
        			//answer = false;
        			return false;
        		}
        	}
        }
        
        System.out.println(answer);
        
        return answer;
    }
}
