package com.example.coding_test.programmers.level1;

import java.util.Arrays;
import java.util.Collections;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/135808
 * 문제 : 과일 장수
 */
public class Fruiterer {


    /**
     *
     * @param k : 사과의 최상등급
     * @param m : m개씩 포장
     * @param score : 사과 점수 배열
     * @return
     */
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);

        for(int i = score.length; i >= m; i -= m) {
            answer += score[i - m] * m;
        }


        return answer;
    }
}
