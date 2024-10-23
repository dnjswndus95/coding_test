package com.example.coding_test.programmers.level2;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/140107
 * 문제 : 점 찍기
 *
 * 해결법
 * 1. 그냥 수학공식을 적용하여 이중포문으로 돌렸더니 시간초과 발생
 *
 *
 * 좌표값 하나를 고정시켜놓고 맥스값을 찾아서 k로 나눈후 그 좌표값에서 가능한 경우의 수를 더한다.
 */

public class Dot {
    public long solution(int k, int d) {
        long answer = 0;
        long d2 = (long) d * d;
        // x 좌표마다 가능한 y의 개수를 찾는다.
        for(int x = 0; x <= d; x +=k ) {
            long x2 = (long) x * x;
            int yMax = (int) Math.sqrt(d2 - x2);
            answer += (yMax/k) + 1;
        }

        return answer;
    }
}
