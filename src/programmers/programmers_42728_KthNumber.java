package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class programmers_42728_KthNumber {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] res = solution(array, commands);
        printArr(res);
        // (outputs) {5, 6, 3}
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            ArrayList<Integer> arr = new ArrayList<>();

            for (int j = commands[i][0]-1; j < commands[i][1]; j++) {
                arr.add(array[j]);
            }

            Collections.sort(arr);
            answer[i] = arr.get(commands[i][2]-1);
        }

        return answer;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }System.out.println();
    }
}
