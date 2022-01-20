package programmers;

import java.util.ArrayList;

public class programmers_77484_TheRankingOfTheLotto {
    public static void main(String[] args) {
        int[] lottos1 = {44, 1, 0, 0, 31, 25};
        int[] win_nums1 = {31, 10, 45, 1, 6, 19};
        int[] ans1 = solution(lottos1, win_nums1);
        System.out.println(ans1[0] + " " + ans1[1]);
        //(Outputs) {3, 5}

        int[] lottos2 = {0, 0, 0, 0, 0, 0};
        int[] win_nums2 = {38, 19, 20, 40, 15, 25};
        int[] ans2 = solution(lottos2, win_nums2);
        System.out.println(ans2[0] + " " + ans2[1]);
        //(Outputs) {1, 6}

        int[] lottos3 = {45, 4, 35, 20, 3, 9};
        int[] win_nums3 = {20, 9, 3, 45, 4, 35};
        int[] ans3 = solution(lottos3, win_nums3);
        System.out.println(ans3[0] + " " + ans3[1]);
        //(Outputs) {1, 1}
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int hit = 0;
        int zero = 0;
        int[] answer = new int[2];
        ArrayList<Integer> winNums = new ArrayList<>();

        for (int i = 0; i < win_nums.length; i++) {     // win_nums - int[] to ArrayList
            if (lottos[i] != 0) {
                winNums.add(win_nums[i]);
            }
        }

        for (int i = 0; i < lottos.length; i++) {       // 당점된 로또 번호 체크
            if (lottos[i] != 0) {
                if (winNums.contains(lottos[i])) {
                    hit++;
                }
            } else {
                zero++;
            }
        }

        answer[0] = 7 - (hit + zero);   // 로또 최고 순위
        answer[1] = 7 - hit;            // 로또 최저 순위

        if (answer[0] == 7) {
            answer[0] = 6;
        }

        if (answer[1] == 7) {
            answer[1] = 6;
        }

        return answer;
    }
}
