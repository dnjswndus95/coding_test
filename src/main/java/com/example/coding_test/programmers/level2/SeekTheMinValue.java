package com.example.coding_test.programmers.level2;

import java.util.Arrays;
import java.util.Collections;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/12941?language=java
 * 문제 : 최솟값 만들기
 */

public class SeekTheMinValue {

    public static void main(String[] args) {

    }

    public int solution(int []A, int []B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);


        for(int i = 0; i < A.length; ++i ) {
            answer += A[i] * B[B.length - 1 - i];
        }

        return answer;
    }
}
