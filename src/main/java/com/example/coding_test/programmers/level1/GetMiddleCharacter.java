package com.example.coding_test.programmers.level1;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/12903
 * 문제 : 가운데 글자 가져오기
 */
public class GetMiddleCharacter {

    public static void main(String[] args) {
        solution("abcde");
    }

    public static String solution(String s) {
        return s.substring((s.length()-1)/2, s.length()/2 + 1);
    }
}
