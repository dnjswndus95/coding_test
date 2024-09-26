package com.example.coding_test.programmers.level2;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/181187
 * 문제 : 두 원 사이의 정수 쌍
 */

public class TwoCircleBetweenDot {

    public long solution(int r1, int r2) {
        long answer = 0;


        // Math.sqrt() 안에 1.0을 곱해주지 않았더니 음수가 r1^2 - i^2 < 0 인 상황에서 에러가 발생할 수 있다.
        for(int i = 1; i <= r2; ++i) {
            long minY = (int) Math.ceil(Math.sqrt(1.0 * r1 * r1 - 1.0 * i * i));
            long maxY = (int) Math.floor(Math.sqrt(1.0 * r2 * r2 - 1.0 * i * i));

            answer += maxY - minY + 1;
        }

        answer *= 4;

        return answer;
    }
}
