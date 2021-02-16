package programmers;

public class programmers_42898_RaodToSchool {

	public static void main(String[] args) {
		int[][] puddles = {{1, 2}};
		solution(4, 3, puddles);
		//(Outputs) 4
	}

    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        long[][] map = new long[n][m];
        
        for(int i=0;i<puddles.length;i++)		// 물 웅덩이
        	map[puddles[i][1]-1][puddles[i][0]-1] = -1;

        for(int i=1;i<m;i++) {		// 留� �쐵以�, 留� �쇊履쎌쨪1濡� 珥덇린
        	if(map[0][i] == -1)		// �떒, 臾쇱썒�뜦�씠媛� �엳�쑝硫� 洹몃떎�쓬�� 0
        		break;
        	map[0][i] = 1;
        }
        for(int i=1;i<n;i++) {
        	if(map[i][0] == -1)
        		break;
        	map[i][0] = 1;
        }
        
        for(int i=1;i<n;i++) {
        	for(int j=1;j<m;j++) {
        		if(map[i][j] == -1)
        			continue;
        		
        		if(map[i-1][j] == -1 && map[i][j-1] == -1)
        			map[i][j] = 0;
        		else if(map[i-1][j] == -1)
        			map[i][j] = map[i][j-1];
        		else if(map[i][j-1] == -1)
        			map[i][j] = map[i-1][j];
        		else
        			map[i][j] = (map[i-1][j] + map[i][j-1]) % 1000000007;
        	}
        }
        
        answer = (int)map[n-1][m-1];
        System.out.println(answer);
//        for(int i=0;i<n;i++) {		// print map
//        	for(int j=0;j<m;j++) {
//        		System.out.print(map[i][j] + "\t");
//        	}System.out.println();
//        }
        
        return answer;
    }
}
