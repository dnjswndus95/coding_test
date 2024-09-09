package com.example.coding_test.programmers.level1;

import java.util.Arrays;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/147355
 * 문제 : 크기가 작은 부분 문자열
 */
public class PartialCharList {

    public static void main(String[] args) {
        solution("5002", "10");
    }

    public static int solution(String t, String p) {
        int answer = 0;

        int numberLength = p.length();
        int partialCount = t.length() - p.length() + 1;
        Long pNumber = Long.parseLong(p);

        for(int i = 0; i < partialCount; ++i) {
            Long partialNumber = Long.parseLong(t.substring(i, i+numberLength));
            if(partialNumber <= pNumber)
                ++answer;
        }


        return answer;
    }
}
