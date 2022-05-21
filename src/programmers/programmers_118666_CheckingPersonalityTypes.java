package programmers;

public class programmers_118666_CheckingPersonalityTypes {
    public static void main(String[] args) {
        String[] survey1 = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices1 = {5, 3, 2, 7, 5};
        String res1 = solution(survey1, choices1);
        System.out.println(res1);               // TCMA

        String[] survey2 = {"TR", "RT", "TR"};
        int[] choices2 = {7, 1, 3};
        String res2 = solution(survey2, choices2);
        System.out.println(res2);               // RCJA
    }

    // 1. R / T
    // 2. C / F
    // 3. J / M
    // 4. A / N
    public static String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        String[] pType = {"R", "T", "C", "F", "J", "M", "A", "N"};
        int[] score = new int[8];

        for (int i = 0; i < survey.length; i++) {           // 동의, 비동의 점수 계산
            if(choices[i] < 4) {
                int idx = getIdx(pType, survey[i].charAt(0));
                score[idx] += 4 - choices[i];
            } else if(choices[i] > 4) {
                int idx = getIdx(pType, survey[i].charAt(1));
                score[idx] += choices[i] - 4;
            }
        }

        for (int i = 0; i < pType.length - 1; i += 2) {     // 최종 결과 합산
            if (score[i] >= score[i+1]) {
                answer.append(pType[i]);
            } else {
                answer.append(pType[i+1]);
            }
        }

        return answer.toString();
    }

    public static int getIdx(String[] pType, char ch) {
        for (int i = 0; i < pType.length; i++) {
            if (pType[i].equals(String.valueOf(ch))) {
                return i;
            }
        }
        return -1;
    }
}
