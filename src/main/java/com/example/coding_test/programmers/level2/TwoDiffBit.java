package com.example.coding_test.programmers.level2;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/77885
 * 문제 : 2개 이하로 다른 비트
 */

public class TwoDiffBit {

    public long[] solution(long[] numbers) {
        long[] answer =  new long[numbers.length];

        for(int i = 0; i < numbers.length; ++i) {
            // number와 number + 1 OR비트연산
            // 쉬프트로 2만큼 밀어서 더한다.
            answer[i] = numbers[i] + 1;
            answer[i] += (numbers[i] ^ answer[i]) >> 2;
        }

        return answer;
    }
}
