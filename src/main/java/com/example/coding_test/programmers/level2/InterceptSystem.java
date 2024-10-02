package com.example.coding_test.programmers.level2;


import java.util.Arrays;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/181188
 * 문제 : 요격 시스템
 */
public class InterceptSystem {

    public int solution(int[][] targets) {
        int answer = 1;

        // 미사일 시작 지점 순으로 정렬
        Arrays.sort(targets, (x, y) -> x[0] - y[0]);

        int preStart = targets[0][0];
        int preEnd = targets[0][1];

        for(int i = 1; i < targets.length; ++i) {

            if(preStart <= targets[i][0] && targets[i][0] < preEnd) {
                preStart = Math.max(preStart, targets[i][0]);
                preEnd = Math.min(preEnd, targets[i][1]);
            }
            else {
                preStart = targets[i][0];
                preEnd = targets[i][1];
                ++answer;
            }
        }

        return answer;
    }
}
