package com.example.coding_test.programmers.level1;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/86491
 * 문제 : 최소직사각형
 */
public class MinimumSquare {

    public int solution(int[][] sizes) {
        int answer = 0;

        int xMax = Integer.MIN_VALUE;
        int yMax = Integer.MIN_VALUE;

        // 뒤집지 않았을 때 명함칸의 크기
        for (int[] size : sizes) {
            xMax = Math.max(xMax, Math.max(size[0], size[1]));
            yMax = Math.max(yMax, Math.min(size[0], size[1]));
        }

        answer = xMax * yMax;

        return answer;
    }
}
