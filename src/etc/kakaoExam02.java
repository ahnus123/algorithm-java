package etc;

import java.util.*;

public class kakaoExam02 {
	public static void main(String[] args) {
		String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		solution(s1);
		//(output) [2, 1, 3, 4]

		String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		solution(s2);
		//(output) [2, 1, 3, 4]

		String s3 = "{{20,111},{111}}";
		solution(s3);
		//(output) [111, 20]

		String s4 = "{{123}}";
		solution(s4);
		//(output) [123]

		String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		solution(s5);
		//(output) [3, 2, 4, 1]
	}
	
	public static int[] solution(String s) {
        int[] answer;
        List<Integer> num = new ArrayList<Integer>();
        
        s = s.substring(2, s.length() - 2);
        String[] str = s.split("\\},\\{");
        
        
        String[] sortStr = sortByLength(str);
        
        for(int i=0;i<sortStr.length;i++) {
        	String[] split = sortStr[i].split(",");
			int[] arrNum = new int[split.length];
			
			for(int k=0;k<split.length;k++)
				arrNum[k] = Integer.parseInt(split[k]);
			
			addList(num, arrNum);
        }
        
        answer = new int[num.size()];
        
        for(int i=0;i<num.size();i++)
        	answer[i] = num.get(i);

        /*for(int i=0;i<num.size();i++) {
        	System.out.print(answer[i] + "\t");
        }System.out.println();*/
        
        return answer;
    }
	
	public static String[] sortByLength(String[] str) {
		String[] resStr = new String[str.length];
		Map<Integer, String> length = new HashMap<Integer, String>();
		
		for(int i=0;i<str.length;i++)
			length.put(str[i].length(), str[i]);

		//길이를 기준으로 정렬
		int idx = 0;
		TreeMap<Integer, String> treemap = new TreeMap<Integer, String>(length);
		Iterator<Integer> it = treemap.keySet().iterator();
		while(it.hasNext()) {
			int key = it.next();
			resStr[idx] = treemap.get(key);
			idx++;
		}
		
		return resStr;
	}
	
	public static void addList(List<Integer> num, int[] arrNum) {
		for(int i=0;i<arrNum.length;i++)
			if(!num.contains(arrNum[i]))
				num.add(arrNum[i]);
	}
}
