package programmers;

public class programmers_49993_SkillTree_Fail {
	public static void main(String[] args) {
		programmers_49993_SkillTree_Fail m = new programmers_49993_SkillTree_Fail();
		
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA", "AAAAAAAAAAA"};
		//(output) 2
		
		m.solution(skill, skill_trees);
	}
	
	public int solution(String skill, String[] skill_trees) {
		/*int answer = 0;

        for(int i=0; i<skill_trees.length;i++){
            boolean flag = true;
            String [] skills = skill_trees[i].split("");
            //System.out.println(Arrays.toString(skills));
            int cnt =0;
            for(int j=0;j<skills.length;j++){
                if(cnt < skill.indexOf(skills[j])){
                    System.out.println(skill.indexOf(skills[j]) + " skills[j]) :  " +skills[j]) ;
                    flag = false;
                    break;
                }
                else if(cnt == skill.indexOf(skills[j]))
                    cnt++;
            }
            if(flag){
                answer++;
            }
            cnt=0;
        }
        
        System.out.println(answer);
        return answer;*/
		
		
        int answer = 0;
        int[][] match = new int[skill_trees.length][skill.length()];
        
        for(int i=0;i<skill_trees.length;i++) {				//스킬트리 입력 배열만큼
        	for(int j=0;j<skill_trees[i].length();j++) {
        		for(int k=0;k<skill.length();k++) {			//스킬트리 순서만큼
        			if(skill_trees[i].charAt(j) == skill.charAt(k)) {		//일치하는 char가 있으면
        				match[i][k] = j + 1;				//일치하는 배열의 자리를 저장
        													//ex) "CBD" > "BACDE" >> match[0] = {3, 1, 4};
        			}
        		}
        	}
        }
        
        for(int i=0;i<match.length;i++) {			
        	boolean noMatch = false;
        	
        	//System.out.println(skill_trees[i]);
        	for(int j=0;j<match[i].length;j++) {		//전부 겹치치 않는 케이스
        		if(match[i][j] == 0) {
        			if(j == match[i].length - 1) {
        				//System.out.println("answer : " + skill_trees[i]);
        				noMatch = true;
        				answer++;
        			}
        		} else {
        			break;
        		}
        	}
        	
        	if(noMatch)			//전부 겹치지 않는 케이스 > 겹치는 케이스는 패쓰
        		continue;
        	
        	for(int j=0;j<match[i].length - 1;j++) {	//스킬 트리 순서대로
        		//일치하는 배열의 자리가 순서대로이면 정답 + 1
        		if((match[i][j] < match[i][j + 1] || match[i][j + 1] == 0) && match[i][j] != 0) {
        			if(j == match[i].length - 2) {
        				//System.out.println("ans : " + skill_trees[i]);
        				answer++;
        			}
        		} else {
        			break;
        		}
        	}
        }
        
        /*for(int i=0;i<match.length;i++) {			//match 배열 출력
        	for(int j=0;j<match[i].length;j++) {
        		System.out.print(match[i][j] + " ");
        	}System.out.println("");
        }System.out.println("");*/
        
        
        System.out.println(answer);
        
        return answer;
    }
}
