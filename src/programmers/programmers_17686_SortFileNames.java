package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class File{
	String head;
	String number;
	String tail;
	
	File(String head, String number, String tail) {
		this.head = head;
		this.number = number;
		this.tail = tail;
	}
}

class CustomComparator implements Comparator<File> {

	@Override
	public int compare(File o1, File o2) {
		if (o1.head.toLowerCase().equals(o2.head.toLowerCase())) {		// head 비교
			return Integer.parseInt(o1.number) - Integer.parseInt(o2.number);	// number 비교
		}	// tail 비교 제외!

		return o1.head.toLowerCase().compareTo(o2.head.toLowerCase());
	}
	
}

public class programmers_17686_SortFileNames {

	public static void main(String[] args) {
		String[] files1 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		solution(files1);
		// (Outputs) {"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"}
		
		String[] files2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		solution(files2);
		// (Outputs) {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"}
	}
	
	public static String[] solution(String[] files) {
        String[] answer = new String[files.length];
    	ArrayList<File> fileList = new ArrayList<>();
        
        for (String file : files) {
        	String head = "";
        	String number = "";
        	String tail = "";
        	
        	for (int i = 0; i < file.length(); i++) {
        		if (isNumber(file.charAt(i))) {		// number 분리
        			number += file.charAt(i);
        			
        			if (i < file.length() - 1 && !isNumber(file.charAt(i+1))) {		// tail 분리
        				tail = file.substring(i+1, file.length());
        				break;
        			}
        		} else {	// head 분리
        			head += file.charAt(i);
        		}
        	}
        	
        	fileList.add(new File(head, number, tail));
        	// System.out.println(head + "\t\t" + number + "\t\t" + tail);
        }
        
        Collections.sort(fileList, new CustomComparator());		// head, number(숫자) 기준 정렬
        
        for (int i = 0; i < answer.length; i++) {
        	answer[i] = fileList.get(i).head + fileList.get(i).number + fileList.get(i).tail;
        	System.out.println(answer[i]);
        }
        
        return answer;
    }
	
	public static boolean isNumber(char ch) {		// 숫자 여부
		if (ch >= '0' && ch <= '9') {
			return true;
		} else {
			return false;
		}
	}
}
