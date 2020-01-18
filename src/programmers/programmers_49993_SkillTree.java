package programmers;

public class programmers_49993_SkillTree {

	public static void main(String[] args) {
		programmers_49993_SkillTree m = new programmers_49993_SkillTree();
		
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		//(output) 2
		
		m.solution(skill, skill_trees);
	}

	public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[][] match = new int[skill_trees.length][skill.length()];
        
        for(int i=0;i<skill_trees.length;i++) {
        	boolean check = true;
        	int skill_num = 0;
        	
        	for(int j=0;j<skill_trees[i].length();j++) {	//스킬트리 입력 배열만큼
        		for(int k=0;k<skill.length();k++) {				//스킬트리 순서만큼
        			if(skill_trees[i].charAt(j) == skill.charAt(k)) {			//같은 char 찾음
        				if(skill.indexOf(skill.charAt(k)) == skill_num) {		//그 위치가 skill_num이면(그 다음순서면)
        					skill_num++;			//다음 순서 갱신
        				} else {												//불가능한 스킬 트리
            				check = false;
            				break;
            			}
        			}
        		}
        	}
        	
        	if(check)		//불가능한 스킬트리가 아니면 정답 + 1
        		answer++;
        }
        
        
        System.out.println(answer);
        
        return answer;
    }
}
