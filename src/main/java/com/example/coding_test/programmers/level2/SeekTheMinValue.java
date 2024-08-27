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
        Integer[] b = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(b, Collections.reverseOrder());


        for(int i = 0; i < A.length; ++i ) {
            answer += A[i] * b[i];
        }

        return answer;
    }
}
