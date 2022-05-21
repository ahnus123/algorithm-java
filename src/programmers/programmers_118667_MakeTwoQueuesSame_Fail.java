package programmers;

import com.sun.org.apache.xpath.internal.res.XPATHErrorResources_ko;

import java.util.LinkedList;
import java.util.Queue;

public class programmers_118667_MakeTwoQueuesSame_Fail {
    public static void main(String[] args) {
        int[] queue11 = {3, 2, 7, 2};
        int[] queue12 = {4, 6, 5, 1};
        int res1 = solution(queue11, queue12);
        System.out.println(res1);       // 2

        int[] queue21 = {1, 2, 1, 2};
        int[] queue22 = {1, 10, 1, 2};
        int res2 = solution(queue21, queue22);
        System.out.println(res2);       // 7

        int[] queue31 = {1, 1};
        int[] queue32 = {1, 5};
        int res3 = solution(queue31, queue32);
        System.out.println(res3);       // -1
    }

    public static int solution(int[] queue1, int[] queue2) {
        int answer = Integer.MAX_VALUE;
        long totalSum = 0;
        int[] total = new int[queue1.length + queue2.length];
        int[] partSum = new int[queue1.length + queue2.length];

        // 2개의 큐를 1개의 배열로 합치기 -> 큐1 + 큐2
        for (int i = 0; i < queue1.length; i++) {
            totalSum += queue1[i];
            total[i] = queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            totalSum += queue2[i];
            total[queue1.length + i] = queue2[i];
        }

        // 부분 합 계산
        partSum[0] = total[0];
        for (int i = 1; i < partSum.length; i++) {
            partSum[i] = partSum[i-1] + total[i];
        }

        int cnt = 0;
        int start = 0;
        int end = queue1.length - 1;
        while (start < total.length) {      // 큐1의 원소를 pop -> 큐2로 이동
            for (int i = 0; i < total.length - end; i++) {      // 큐2의 원소를 pop -> 큐1로 이동
                int newCnt = cnt + i;
                if (partSum[end + i] == totalSum/2) {
//                    System.out.println("start : " + start + " / end : " + end + " / newCnt : " + newCnt + " (cnt:" + cnt + "/i:" + i + ")");
                    if (newCnt < answer) {
                        answer = newCnt;
                    }
                }
            }

            for (int i = 0; i < partSum.length; i++) {
                partSum[i] -= total[start];
            }

            cnt++;
            start++;
        }

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }

        return answer;
    }
}
