package com.example.coding_test.programmers.level1;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/132267
 * 문제 : 콜라 문제
 */
public class ColaProblem {

    public static void main(String[] args) {
        int solution = solution(2, 1, 20);
        System.out.println(solution);
    }
    public static int solution(int a, int b, int n) {
        int answer = 0;

        // a개를 가져다 주면 b병을 준다. n개의 빈병을 주면 몇개를 받을 수 있는가

        while(n >= a) {
            int quotient = n / a;
            int remain = n % a;

            answer += quotient * b;

            n = quotient * b + remain;
        }


        return answer;
    }
}
