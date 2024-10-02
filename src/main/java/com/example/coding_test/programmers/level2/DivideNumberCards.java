package com.example.coding_test.programmers.level2;

import java.util.Arrays;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/135807
 * 문제 : 숫자 카드 나누기
 *
 * 가장 먼저 각 배열의 최대공약수를 구해야 한다...
 * 유클리드 호제법 사용
 */
public class DivideNumberCards {

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for(int i = 1; i < arrayA.length; ++i) {
            gcdA = getGCD(arrayA[i], gcdA);
            gcdB = getGCD(arrayB[i], gcdB);
        }

        if(isDivide(arrayA, gcdB))
           gcdB = 0;

        if(isDivide(arrayB, gcdA))
            gcdA = 0;

        answer = Math.max(gcdA, gcdB);

        return answer;
    }

    public static int getGCD(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static boolean isDivide(int[] array, int gcd) {
        for (int i : array) {
            if(i % gcd == 0)
                return true;
        }
        return false;
    }
}
