package programmers;

import java.util.ArrayList;
import java.util.List;

public class programmers_1835_TakingAGroupPhoto {
	static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

	public static void main(String[] args) {
		String[] data1 = {"N~F=0", "R~T>2"};
		solution(2, data1);
		//(output) 3648
		
		String[] data2 = {"M~C<2", "C~M>1"};
		solution(2, data2);
		//(output) 7200
	}

	static public int solution(int n, String[] data) {
		int answer = 0;
        int[] check = new int[8];
        char[][] charData = new char[n][5];
        List<Character> arr = new ArrayList<Character>();
        
        for(int i=0;i<n;i++)		//조건 - String > char[]
        	for(int j=0;j<5;j++)
        		charData[i][j] = data[i].charAt(j);
        
        answer = permutation(arr, check, 8, 8, charData);
        
        System.out.println(answer);
        return answer;
    }
	
	//순열 함수
	static public int permutation(List<Character> arr, int[] check, int n, int r, char[][] charData) {
		int answer = 0;
		
		if(arr.size() == r) {		//순열 완성
			/*for(int i=0;i<arr.size();i++) {			//print
				System.out.print(arr.get(i) + "  ");
			}System.out.println();*/
			
			if(dataCheck(arr, charData))			//조건 체크
				answer++;
			
			return answer;
		}
		
		for(int i=0;i<n;i++) {
			if(check[i] == 0) {
				check[i] = 1;
				arr.add(friends[i]);
				answer += permutation(arr, check, n, r, charData);
				arr.remove(arr.size() - 1);
				check[i] = 0;
			}
		}
		
		return answer;
	}
	
	//조건 체크 함수
	static public boolean dataCheck(List<Character> arr, char[][] charData) {
		boolean res = true;
		
		int size = charData.length;
		for(int i=0;i<size;i++) {
			int idx1 = arr.indexOf(charData[i][0]);
			int idx2 = arr.indexOf(charData[i][2]);
			int num = charData[i][4] - '0';
			
			if(charData[i][3] == '>') {							//조건 체크
				if(Math.abs(idx1 - idx2) <= num + 1)
					res = false;
			} else if(charData[i][3] == '=') {
				if(Math.abs(idx1 - idx2) != num + 1)
					res = false;
			} else if(charData[i][3] == '<') {
				if(Math.abs(idx1 - idx2) >= num + 1)
					res = false;
			}
			
			if(!res)			//조건이 1개라도 안맞으면 false return
				return res;
		}
		
		return res;
	}
}
