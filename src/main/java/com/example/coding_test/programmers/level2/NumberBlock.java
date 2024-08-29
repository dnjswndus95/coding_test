package com.example.coding_test.programmers.level2;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/12923
 * 문제 : 숫자 블록
 */
public class NumberBlock {

    public int[] solution(long begin, long end) {
        int first = (int) begin;
        int last = (int) end;
        int[] answer = new int[last - first + 1];
        int idx = 0;

        for(int i = first; i <= last; ++i) {
            if(i == 1) {
                answer[idx] = 0;
            } else {
                answer[idx] = getQuotient(i);
            }
            ++idx;
        }

        return answer;
    }

    public int getQuotient(int num) {
        int result = 1;

        for(int i = 2; i <= Math.sqrt(num); ++i) {
            if(num % i == 0) {
                result = i;

                if(num / i <= 10000000) {
                    result = num / i;
                    break;
                }
            }
        }
        return result;
    }
}
