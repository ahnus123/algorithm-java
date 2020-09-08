package programmers;

public class programmers_12904_TheLongestPalindrome {

	public static void main(String[] args) {
		solution("abcdcba");
		//(output) 7
		
		solution("abacde");
		//(output) 3
	}

	public static int solution(String s)
    {
        int answer = 0;

        for(int i=s.length();i>0;i--) {
        	for(int j=0;j<s.length()-i+1;j++) {
        		boolean same = true;
            	int subStringStart = j;
            	int subStringEnd = j+i-1;
            	int subStart1 = 0;		int subEnd1 = 0;
            	int subStart2 = 0;		int subEnd2 = 0;
            	

        		subStart1 = j;			subEnd1 = j+i/2-1;
        		subEnd2 = j+i-1;
            	if(i%2 == 0)	//문자열 길이 = 짝수
            		subStart2 = j+i/2;
            	else	//문자열 길이 = 홀수
            		subStart2 = j+i/2+1;
            	
//            	System.out.println(s.substring(j, j+i));
//            	System.out.println(s.substring(subStart1, subEnd1+1) + " / "
//            			+ s.substring(subStart2, subEnd2+1) + "\n");
        		
            	int idx = 0;
        		for(int k=subStart1;k<=subEnd1;k++) {		//문자열/2 앞쪽 == 문자열/2 뒤쪽
        			if(s.charAt(k) != s.charAt(subEnd2-idx)) {
    					same = false;
    					break;
        			}
        			idx++;
        		}
            	
            	if(same) {		//팰린드롬 최대
            		answer = i;
            		break;
            	}
        	}
        	if(answer > 0)
        		break;
        }

        System.out.println(answer);
        return answer;
    }
	//substring 사용 || 팰린드롬 비교 함수 생성 => 효율성 통과 안됨
}
