package datastructure;

import java.util.Arrays;

public class array {
    public static void main(String[] args) {
        // 배열 선언
        int[] arr1;
        int arr2[];

        // 배열 생성 & 할당®®
        int[] arr3 = new int[5];

        // 배열 선언 & 초기화
        int[] num1 = {1, 2, 3, 4, 5};
        int[] num5 = new int[] {1, 2, 3, 4, 5};

        // 배열 조회
        System.out.println("--------- 배열 조회 ---------");
        for (int i = 0; i < num1.length; i++) {
            System.out.print(num1[i] + " ");
        }System.out.println();
        for (int n : num1) {
            System.out.print(n + " ");
        }System.out.println();
        // (Outputs) 1 2 3 4 5

        // binarySearch(배열, 검색값) : 이진 검색 트리를 이용한 검색
        System.out.println("--------- binarySearch() ---------");
        System.out.println(Arrays.binarySearch(num1, 3));
        // (Outputs) 2

        // copyOf(원본배열, 복사할 요소의 개수) : 배열 복사
        System.out.println("--------- copyOf() ---------");
        int[] copyArr = Arrays.copyOf(num1, 3);
        printArr(copyArr);
        // (Outputs) 1 2 3

        // copyOfRange(배열, 복사할 시작 인덱스, 복사할 끝 인덱스) : 배열 복사
        System.out.println("--------- copyOfRange() ---------");
        int[] copyOfArr = Arrays.copyOfRange(num1, 2, 4);
        printArr(copyOfArr);
        // (Outputs) 3 4

        // fill(배열, 초기화할 값) : 배열 초기화
        System.out.println("--------- fill() ---------");
        int[] fillArr = new int[10];
        Arrays.fill(fillArr, 7);
        printArr(fillArr);
        // (Outputs) 7 7 7 7 7 7 7 7 7 7


        // sort() : 배열 정렬(오름차순)
        System.out.println("--------- sort() ---------");
        int[] sortArr = {6, 2, 5, 3, 4, 1};
        Arrays.sort(sortArr);
        printArr(sortArr);
        // (Outputs) 1 2 3 4 5 6

        // equals() : 배열 정렬(오름차순)
        System.out.println("--------- equals() ---------");
        int[] equalArr1 = {1, 2, 3};
        int[] equalArr2 = {1, 2, 3};
        System.out.println(Arrays.equals(equalArr1, equalArr2));
        // (Outputs) true
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
