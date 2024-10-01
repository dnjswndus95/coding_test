package com.example.coding_test.programmers.level2;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/12911
 * 문제 : 다음 큰 숫자
 */
public class NextBiggerNumber {

    public static void main(String[] args) {
        solution(12);
    }

    public static int solution(int n) {

        int countOfOne = Integer.bitCount(n);

        while(true) {
            n += 1;

            if(countOfOne == Integer.bitCount(n))
                break;
        }

        return n;
    }


    /**
     * int postPattern = n & -n, smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;
     *         return n + postPattern | smallPattern;
     */
}
