package com.example.coding_test.programmers.level2;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/12899?language=java
 * 문제 : 124 나라의 숫자
 *
 * 아이디어
 * 1. 사실상 3진수이다.
 * 2. 3으로 나눈 나머지가  0이면 4, 1이면 1, 2이면 2
 */

public class Country124 {

    public static void main(String[] agrs) {
        solution(3);
    }

    public static String solution(int n) {
        String[] numbers = {"4", "1", "2"};
        String answer = "";

        while(n > 0) {
            int remainder = n%3;
            n = n/3;

            if(remainder == 0)
                n -= 1;

            answer = numbers[remainder] + answer;
        }
        return answer;
    }
}
