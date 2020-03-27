package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class programmers_1829_KakaoFriendsColoringBook {

	public static void main(String[] args) {
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		solution(6, 4, picture);
		//(output) {4, 5}
	}

	public static int[] solution(int m, int n, int[][] picture) {
		List<Integer> list = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < m; i++) {
			ArrayList<Integer> in = new ArrayList<>();
			for (int j = 0; j < n; j++)
				in.add(picture[i][j]);
			input.add(in);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (input.get(i).get(j) != 0) {
					list.add(findComplex(input, i, j, input.get(i).get(j), n, m));
				}
			}
		}

		Collections.sort(list);

		int[] answer = new int[2];
		answer[0] = list.size();
		answer[1] = list.get(list.size() - 1);

		System.out.println(answer[0] + " " + answer[1]);

		return answer;
	}

	public static int findComplex(ArrayList<ArrayList<Integer>> picture, int x, int y, int color, int n, int m) {
		int res = 1;
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, -1, 0, 1 };

		picture.get(x).set(y, 0);
		for (int i = 0; i < 4; i++) { // 4방향 탐색
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < m && ny < n) { // 다음 좌표가 범위내에 있으면
				if (picture.get(nx).get(ny) == color) { // 다음 좌표 값 == 1
					res += findComplex(picture, nx, ny, color, n, m); // 다음 좌표에서 findComplex 함수 다시 실행
																	// + 리턴 값 res에 더하기
				}
			}
		}
		return res;
	}
}
