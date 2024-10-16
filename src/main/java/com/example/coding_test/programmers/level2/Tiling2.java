package com.example.coding_test.programmers.level2;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/12900
 * 문제 : 2 x n 타일링
 */

public class Tiling2 {

    public int solution(int n) {

        if(n <= 3)
            return n;

        int[] arr = new int[n + 1];

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;



        for(int i = 4; i <= n; ++i) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
        }

        return arr[n];
    }
}
