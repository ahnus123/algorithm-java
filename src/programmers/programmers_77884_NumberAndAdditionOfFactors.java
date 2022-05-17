package programmers;

public class programmers_77884_NumberAndAdditionOfFactors {
    public static void main(String[] args) {
        int res1 = solution(13, 17);
        System.out.println(res1);
        // (outputs) 43

        int res2 = solution(24, 27);
        System.out.println(res2);
        // (outputs) 52
    }

    public static int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int cnt = findFactors(i);
            if (cnt % 2 == 0) {     // 약수의 개수가 짝수인 경우
                answer += i;
            } else {                // 약수의 개수가 홀수인 경우
                answer -= i;
            }
        }

        return answer;
    }

    // 약수 개수 찾기
    public static int findFactors(int num) {
        int cnt = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                cnt++;
            }
        }

        return cnt;
    }
}
