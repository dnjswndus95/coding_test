package com.example.coding_test.programmers.level2;

public class VowelDictionary {

    public static void main(String[] args) {
        solution("AAAE");
    }

    public static int solution(String word) {
        int answer = 0;

        String indexStr = "AEIOU";
        int per = 3905;

        for (String s : word.split("")) {
            per /= 5;
            answer += indexStr.indexOf(s) * per + 1;
        }

        return answer;
    }

}
