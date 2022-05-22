package programmers;

public class programmers_42747_HIndex {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        int res = solution(citations);
        System.out.println(res);
        // (outputs) 3
    }

    public static int solution(int[] citations) {
        int answer = 0;
        int[] citCnt = new int[10001];      // citCnt[점수] = 인용된 논문 수

        for (int i = 0; i < citations.length; i++) {
            for (int j = 1; j <= citations[i]; j++) {
                citCnt[j]++;
            }
        }

        for (int i = citCnt.length-1; i > 0; i--) {     // 최대 H Index 구하기
            if (citCnt[i] >= i) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
