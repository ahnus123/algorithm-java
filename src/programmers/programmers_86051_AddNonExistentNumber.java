package programmers;

import java.util.Arrays;

public class programmers_86051_AddNonExistentNumber {
    public static void main(String[] args) {
        int[] numbers1 = {1,2,3,4,6,7,8,0};
        int res1 = solution(numbers1);
        System.out.println(res1);
        // (outputs) 14

        int[] numbers2 = {5,8,4,0,6,7,9};
        int res2 = solution(numbers2);
        System.out.println(res2);
        // (outputs) 6
    }

    public static int solution(int[] numbers) {
        int answer = 0;

        int idx = 0;
        Arrays.sort(numbers);       // numbers 정렬
        for (int i = 0; i < 10; i++) {
            if (i == numbers[idx]) {    // 0~9 사이에 numbers와 일치하는 수가 있는 경우
                if (idx < numbers.length - 1) {
                    idx++;
                }
            } else {
                answer += i;
            }
        }

        return answer;
    }
}
