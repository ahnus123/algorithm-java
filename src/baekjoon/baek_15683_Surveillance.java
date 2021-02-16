package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class baek_15683_Surveillance {
	public static int answer = 100;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	//input
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<ArrayList<Integer>> camera = new ArrayList<ArrayList<Integer>>();
		int[][] office = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				office[i][j] = sc.nextInt();
				if(office[i][j] >= 1 && office[i][j] <= 5) {
					ArrayList<Integer> c = new ArrayList<>();
					c.add(office[i][j]);	c.add(i);		c.add(j);
					camera.add(c);
				}
			}
		}
		
		cameraOn(camera, office, 0);
		
		System.out.println(answer);
	}

	public static void cameraOn(ArrayList<ArrayList<Integer>> camera, int[][] office, int idx) {
		if(idx == camera.size()) {		//전체카메라 on 끝!
			if(countZero(office) < answer) {
				answer = countZero(office);
				System.out.println("ans : " + answer);
				printOffice(office);
			}
			return;
		}
		
		if(camera.get(idx).get(0) == 1) {
			for(int i=0;i<4;i++) {
				int[][] tempOffice = new int[office.length][office[0].length];
				copyArr(office, tempOffice);
				cameraDir(tempOffice, camera.get(idx).get(1), camera.get(idx).get(2), i);	//왼쪽, 위쪽, 오른쪽, 아래쪽 순서대로
				cameraOn(camera, tempOffice, idx+1);
			}
		} else if(camera.get(idx).get(0) == 2) {
			int i = 0;
			while(i <= 1) {
				if(i == 0) {
					int[][] tempOffice = new int[office.length][office[0].length];
					copyArr(office, tempOffice);
					cameraDir(tempOffice, camera.get(idx).get(1), camera.get(idx).get(2), 0);	//왼쪽
					cameraDir(tempOffice, camera.get(idx).get(1), camera.get(idx).get(2), 2);	//오른쪽
					cameraOn(camera, tempOffice, idx+1);
					i++;
				} else if(i == 1) {
					int[][] tempOffice = new int[office.length][office[0].length];
					copyArr(office, tempOffice);
					cameraDir(tempOffice, camera.get(idx).get(1), camera.get(idx).get(2), 1);	//위쪽
					cameraDir(tempOffice, camera.get(idx).get(1), camera.get(idx).get(2), 3);	//아래쪽
					cameraOn(camera, tempOffice, idx+1);
					i++;
				}
			}
		} else if(camera.get(idx).get(0) == 3) {
			for(int i=0;i<4;i++) {
				int[][] tempOffice = new int[office.length][office[0].length];
				copyArr(office, tempOffice);
				cameraDir(tempOffice, camera.get(idx).get(1), camera.get(idx).get(2), i);
				cameraDir(tempOffice, camera.get(idx).get(1), camera.get(idx).get(2), (i+1)%4);	//직각방향
				cameraOn(camera, tempOffice, idx+1);
			}
		} else if(camera.get(idx).get(0) == 4) {
			for(int idx_dir=0;idx_dir<4;idx_dir++) {
				int[][] tempOffice = new int[office.length][office[0].length];
				copyArr(office, tempOffice);
				for(int i=0;i<4;i++) {		//왼쪽, 위쪽, 오른쪽, 아래쪽순서대로 제외하며 3방향 감시
					if(i != idx_dir)
						cameraDir(tempOffice, camera.get(idx).get(1), camera.get(idx).get(2), i);
				}
				cameraOn(camera, tempOffice, idx+1);
			}
			cameraOn(camera, office, idx+1);
		} else if(camera.get(idx).get(0) == 5) {
			int[][] tempOffice = new int[office.length][office[0].length];
			copyArr(office, tempOffice);
			for(int i=0;i<4;i++)
				cameraDir(tempOffice, camera.get(idx).get(1), camera.get(idx).get(2), i);
			cameraOn(camera, tempOffice, idx+1);
		}
	}
	
	public static void cameraDir(int[][] office, int x, int y, int dir) {
		switch(dir) {
		case 0:		//왼쪽 감시
			for(int j=y;j>=0;j--) {
				if(office[x][j] == 0)
					office[x][j] = 9;
				else if(office[x][j] == 6)
					return;
			}
			break;
		case 1:		//위쪽 감시
			for(int i=x;i>=0;i--) {
				if(office[i][y] == 0) 
					office[i][y] = 9;
				else if(office[i][y] == 6)
					return;
			}
			break;
		case 2:		//오른쪽 감시
			for(int j=y;j<office[x].length;j++) {
				if(office[x][j] == 0)
					office[x][j] = 9;
				else if(office[x][j] == 6)
					return;
			}
			break;
		case 3:		//아래쪽 감시
			for(int i=x;i<office.length;i++) {
				if(office[i][y] == 0) 
					office[i][y] = 9;
				else if(office[i][y] == 6)
					return;
			}
			break;
		}
	}
	
	public static int countZero(int[][] office) {		//빈 칸 카운트
		int zeroCnt = 0;
		for(int i=0;i<office.length;i++)
			for(int j=0;j<office[i].length;j++)
				if(office[i][j] == 0)
					zeroCnt++;
		return zeroCnt;
	}
	
	public static void printOffice(int[][] office) {		//사무실 현황 print
		for(int i=0;i<office.length;i++) {
			for(int j=0;j<office[i].length;j++) {
				System.out.print(office[i][j] + " ");
			}System.out.println("");
		}System.out.println("");
	}
	
	public static void copyArr(int[][] arr1, int[][] arr2) {	//배열 복사
		for(int i=0;i<arr1.length;i++)
			for(int j=0;j<arr1[i].length;j++)
				arr2[i][j] = arr1[i][j];
	}
}


/*
4 6
0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 0 6 0
0 0 0 0 0 0
(output) 20
6 6
0 0 0 0 0 0
0 2 0 0 0 0
0 0 0 0 6 0
0 6 0 0 2 0
0 0 0 0 0 0
0 0 0 0 0 5
(output) 15
6 6
1 0 0 0 0 0
0 1 0 0 0 0
0 0 1 0 0 0
0 0 0 1 0 0
0 0 0 0 1 0
0 0 0 0 0 1
(output) 6
6 6
1 0 0 0 0 0
0 1 0 0 0 0
0 0 1 5 0 0
0 0 5 1 0 0
0 0 0 0 1 0
0 0 0 0 0 1
(output) 2
1 7
0 1 2 3 4 5 6
(output) 0
3 7
4 0 0 0 0 0 0
0 0 0 2 0 0 0
0 0 0 0 0 0 4
(output) 0
*/
