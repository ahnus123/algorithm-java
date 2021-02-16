package baekjoon;

import java.util.*;

public class baek_17144_ByeDust {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		int r = sc.nextInt();
		int c = sc.nextInt();
		int t = sc.nextInt();
		int[][] room = new int[r][c];
		int[] robot = new int[2];
		
		for(int i=0;i<r;i++)			//input
			for(int j=0;j<c;j++)
				room[i][j] = sc.nextInt();
		
		for(int i=0;i<r;i++)
			for(int j=0;j<c;j++)
				if(room[i][j] == -1)
					robot[1] = i;
		robot[0] = robot[1] - 1;

		//printRoom(room);
		
		for(int times=0;times<t;times++) {
			int[][] spread = new int[r][c];
			for(int i=0;i<r;i++) {			//¹Ì¼¼¸ÕÁö È®»ê
				for(int j=0;j<c;j++) {
					if(room[i][j] > 0) {
						int dx[] = {-1, 0, 1, 0};
						int dy[] = {0, -1, 0, 1};
						int spreadCount = 0;
						
						for(int d=0;d<4;d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							
							if(nx >= 0 && ny >= 0 && nx < r && ny < c) {
								if(room[nx][ny] >= 0) {
									spread[nx][ny] += room[i][j] / 5;
									spreadCount++;
								}
							}
						}
						spread[i][j] += room[i][j] - (room[i][j] / 5) * spreadCount;
					}
				}
			}
			
			//printRoom(room);
			
			for(int i=0;i<r;i++)
				for(int j=0;j<c;j++)
					room[i][j] = spread[i][j];		//È®»ê ¹Ì¼¼¸ÕÁö ´õÇÏ±â
			room[robot[0]][0] = -1;		room[robot[1]][0] = -1;
			
			//printRoom(room);
			
			//°ø±âÃ»Á¤±â °¡µ¿
			for(int i=0;i<robot[0]-1;i++)		//À­Ä­ À§ > ¾Æ·¡
				room[i+1][0] = room[i][0];
			for(int j=0;j<c-1;j++)				//À­Ä­ ¿À¸¥ > ¿Þ
				room[0][j] = room[0][j+1];
			for(int i=0;i<robot[0];i++)			//À­Ä­ ¾Æ·¡ > À§
				room[i][c-1] = room[i+1][c-1];
			for(int j=c-1;j>=2;j--)				//À­Ä­ ¿Þ > ¿À
				room[robot[0]][j] = room[robot[0]][j-1];
			room[robot[0]][1] = 0;				//°ø±âÃ»Á¤ ½ÃÀÛÄ­
			
			for(int i=robot[1]+1;i<r-1;i++)		//¾Æ·¡Ä­ ¾Æ·¡ > À§
				room[i][0] = room[i+1][0];
			for(int j=0;j<c-1;j++)				//¾Æ·¡Ä­ ¿À¸¥ > ¿Þ
				room[r-1][j] = room[r-1][j+1];
			for(int i=r-1;i>=robot[1]+1;i--)	//¾Æ·¡Ä­ À§ > ¾Æ·¡
				room[i][c-1] = room[i-1][c-1];
			for(int j=c-1;j>=2;j--)				//¾Æ·¡Ä­ ¿Þ > ¿À¸¥
				room[robot[1]][j] = room[robot[1]][j-1];
			room[robot[1]][1] = 0;				//°ø±âÃ»Á¤ ½ÃÀÛÄ­
			
			//printRoom(room);
		}
		
		for(int i=0;i<r;i++)
			for(int j=0;j<c;j++)
				answer += room[i][j];
		answer += 2;
		
		System.out.println(answer);
	}

	public static void printRoom(int[][] room) {
		for(int i=0;i<room.length;i++) {
			for(int j=0;j<room[i].length;j++) {
				System.out.print(room[i][j] + "\t");
			}System.out.println();
		}System.out.println();
	}
}


/* (input)
7 8 1
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0
 */
//(output) 188

/* (input)
7 8 2
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0
 */
//(output) 188


/* (input)
7 8 3
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0
 */
//(output) 186


/* (input)
7 8 4
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0
 */
//(output) 178


/* (input)
7 8 5
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0
 */
//(output) 172


/* (input)
7 8 20
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0
 */
//(output) 71


/* (input)
7 8 30
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0
 */
//(output) 52


/* (input)
7 8 50
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0
 */
//(output) 46
