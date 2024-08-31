package com.example.coding_test.programmers.level2;

import java.util.Arrays;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/181188
 * 문제 : 요격 시스템
 */
public class InterceptSystem {

    public int solution(int[][] targets) {
        int answer = 1;

        // 시작 점을 기준으로 정렬
        Arrays.sort(targets, ((x, y) -> x[0] - y[0]));

        int preStart = targets[0][0];
        int preEnd = targets[0][1];

        for(int i = 1; i < targets.length; ++i) {
            int curStart = targets[i][0];
            int curEnd = targets[i][1];

            // 현재 미사일이 전 미사일을 범위내에서 커버가 되는가
            if(preStart <= curStart && curStart < preEnd) {
                preStart = Math.max(preStart, curStart);
                preEnd = Math.min(preEnd, curEnd);
            } else {
                preStart = curStart;
                preEnd = curEnd;
                ++answer;
            }
        }

        return answer;
    }
}
