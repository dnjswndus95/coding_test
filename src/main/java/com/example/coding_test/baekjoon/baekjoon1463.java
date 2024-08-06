package com.example.coding_test.baekjoon;

import java.util.Scanner;

public class baekjoon1463 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int answer = 0;

        // i번째 인덱스는 숫자 i가 1이 되기 위한 최소 연산수를 저장.
        int[] arr = new int[num+1];
        arr[1] = 0;

        for(int i = 2; i <= num; ++i) {
            arr[i] = arr[i-1] + 1;
            if(i % 2 == 0) {
                arr[i] = Math.min(arr[i], arr[i/2] + 1);
            }
            if(i % 3 == 0){
                arr[i] = Math.min(arr[i], arr[i/3] + 1);
            }
        }

        answer = arr[num];

        System.out.println("answer ====> " + answer);
    }
}
