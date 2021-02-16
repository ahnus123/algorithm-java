package programmers;

public class programmers_42898_RoadToSchool2 {

	public static void main(String[] args) {
		int[][] puddles = {{2, 2}};
		solution(4, 3, puddles);
		//(Outputs) 4
	}

    public static int solution(int m, int n, int[][] puddles) {
    	int answer = 0;
        long[][] map = new long[n][m];
        
        for (int i = 0; i < puddles.length; i++) {		// ¹° ¿õµ¢ÀÌ
            map[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        
        for (int i = 1; i < map.length; i++) {			// 1¹øÂ° ¿­À» 1·Î ÃÊ±âÈ­
            if (map[i][0] == -1) {
                break;
            }
            map[i][0] = 1;
        }
        for (int j = 1; j < map[0].length; j++) {		// 1¹øÂ° ÇàÀ» 1·Î ÃÊ±âÈ­
            if (map[0][j] == -1) {
                break;
            }
            map[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (map[i][j] == -1) {		// ¹° ¿õµ¢ÀÌ
                    continue;
                }

                if (map[i-1][j] == -1 && map[i][j-1] == -1) {	// ¿Þ&À§ ¸ðµÎ ¹°¿õµ¢ÀÌ
                    map[i][j] = 0;
                } else if (map[i-1][j] == -1) {		// À§ ¹°¿õµ¢ÀÌ
                    map[i][j] = map[i][j-1];
                } else if (map[i][j-1] == -1) {		// ¾Æ·¡ ¹°¿õµ¢ÀÌ
                    map[i][j] = map[i-1][j];
                } else {
                    map[i][j] = (map[i-1][j] + map[i][j-1]) % 1000000007;
                }
            }
        }

        answer = (int)map[n-1][m-1];
        
//        System.out.println(answer);
//        for(int i=0;i<map.length;i++) {
//        	for(int j=0;j<map[i].length;j++) {
//        		System.out.print(map[i][j] + "\t");
//        	}System.out.println();
//        }System.out.println();
        
        return answer;
    }
}
