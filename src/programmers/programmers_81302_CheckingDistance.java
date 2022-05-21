package programmers;

import java.util.Arrays;

public class programmers_81302_CheckingDistance {
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] res = solution(places);
        printArr(res);
        // (outputs) {1, 0, 1, 1, 1}
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);

        for (int p = 0; p < places.length; p++) {
            boolean done = false;
            for (int i = 0; i < places[0].length; i++) {
                for (int j = 0; j < places[p][i].length(); j++) {
                   if (places[p][i].charAt(j) == 'P') {     // 3가지 방법으로 주변 응시자를 탐색
                       boolean pass1 = lookAround1(places[p], i, j);
                       boolean pass2 = lookAround2(places[p], i, j);
                       boolean pass3 = lookAround3(places[p], i, j);
                       if (!(pass1 && pass2 && pass3)) {    // 1가지라도 거리두기 조건을 위반하면 0
                           answer[p] = 0;
                           done = true;
                           break;
                       }
                   }
                }
                if (done) {
                    break;
                }
            }
        }

        return answer;
    }

    // 인접한 4개 자리(상하좌우) 탐색
    public static boolean lookAround1(String[] place, int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < place.length && ny >= 0 && ny < place.length) {
                if (place[nx].charAt(ny) == 'P') {
                    return false;
                }
            }
        }
        return true;
    }

    // 인접한 대각선 4개 자리 탐색
    public static boolean lookAround2(String[] place, int x, int y) {
        int[] dx = {-1, -1, 1, 1};
        int[] dy = {-1, 1, -1, 1};
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < place.length && ny >= 0 && ny < place.length) {
                if (place[nx].charAt(ny) == 'P' && !(place[nx].charAt(y) == 'X' && place[x].charAt(ny) == 'X')) {
                    return false;
                }
            }
        }
        return true;
    }

    // 거리가 2인 4개 자리 탐색
    public static boolean lookAround3(String[] place, int x, int y) {
        int[] dx = {-2, 0, 2, 0};
        int[] dy = {0, -2, 0, 2};
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < place.length && ny >= 0 && ny < place.length) {
                if (place[nx].charAt(ny) == 'P') {
                    if (i % 2 == 1 && place[x].charAt(y+dy[i]/2) != 'X') {
                        return false;
                    } else if (i % 2 == 0 && place[x+dx[i]/2].charAt(y) != 'X') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }System.out.println();
    }
}
