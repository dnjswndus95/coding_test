package com.example.coding_test.programmers.level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

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
        Integer[] scoreList = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(scoreList, Collections.reverseOrder());

        for(int i = 0; i < scoreList.length; i += m) {
            if ((i + 1) % m == 0) {
                answer += scoreList[i] * m;
            }
        }


        return answer;
    }
}
