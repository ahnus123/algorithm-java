package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class programmers_42628_DoublePriorityQueue {
    public static void main(String[] args) {
        String[] operations1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        int[] res1 = solution(operations1);
        printArr(res1);
        // (outputs) {0,0}

        String[] operations2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] res2 = solution(operations2);
        printArr(res2);
        // (outputs) {333, -45}
    }

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < operations.length; i++) {
            String[] s = operations[i].split(" ");

            if (s.length >= 1) {
                if (s[0].equals("I")) {     // 큐에 주어진 숫자를 삽입
                    arr.add(Integer.parseInt(s[1]));
                    Collections.sort(arr);
                } else if (s[0].equals("D")) {      // 큐에서 최대값/최소값을 삭제
                    if (s[1].equals("1")) {         // 최대값 삭제
                        if (arr.size() > 0) {
                            arr.remove(arr.size() - 1);
                        }
                    } else if (s[1].equals("-1")) { // 최소값 삭제
                        if (arr.size() > 0) {
                            arr.remove(0);
                        }
                    }
                }
            }
        }

        if (arr.size() > 0) {
            answer[0] = arr.get(arr.size()-1);
            answer[1] = arr.get(0);
        }

        return answer;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }System.out.println();
    }
}
