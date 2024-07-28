package com.example.coding_test.level1;

import java.util.Arrays;

/**
 *  주소 : https://school.programmers.co.kr/learn/courses/30/lessons/155652
 *  이름 : 둘만의 암호
 */
public class OurPassword {
    public static void main(String[] args) {
        String answer = OurPassword.solution("aukks", "wbqd", 5);
        System.out.println("answer ===> " + answer);
    }

    public static String solution(String s, String skip, Integer index) {

        String answer = "";

        for(int i = 0; i < s.length(); ++i ){
            char temp = s.charAt(i);
            for(int j = 0; j < index;) {
                temp = (char)((int)temp + 1);
                if(temp > 'z')
                    temp = 'a';

                if(skip.indexOf(temp) >= 0)
                    continue;
                ++j;
            }
            answer += temp;
        }
        return answer;
    }
}
