package programmers;

public class programmers_17687_NNotationGame {

	public static void main(String[] args) {
		solution(2, 4, 2, 1);
		//(output) 0111
		
		solution(16, 16, 2, 1);
		//(output) 02468ACE11111111
		
		solution(16, 16, 2, 2);
		//(output) 13579BDF01234567
	}

	public static String solution(int n, int t, int m, int p) {		//n:진법, t:미리 구할 숫자 갯수, m:게임 참가 인원, p:튜브 순서
		int count= 0;
		String number ="";	
		
		while(number.length()<=t*m+(p-1)) {
			String target="";
			int val = count;
			if(val<n) {							//0~15(16진법), 0~5(6진법) 셋팅
				if(val>=10)
					target+=(char)(val+55);
				else
					target+=val;
			}else {
				while(true) {
					if(val%n>=10)
						target=(char)(val%n+55)+target;
					else
						target=val%n+target;
																					
					val=val/n;															
					if(val<n) {
						if(val>=10)
							target=(char)(val)+target;
						else
							target=val+target;
									
						break;
					}
				}
			}			
			number+=target;
			count++;						
		}	
		String result="";
		int ch=p-1;
		int stop = 0;
		while(true) {
			result+=number.charAt(ch);
			ch+=m;
			stop++;
			if(stop==t) {
				break;
			}
		}
//		for(int i =p-1; i<t*m;i+=m) {
//			result+=number.charAt(i);
//		}
		//System.out.println(number);

		System.out.println(result);
        return result;
	}
}
