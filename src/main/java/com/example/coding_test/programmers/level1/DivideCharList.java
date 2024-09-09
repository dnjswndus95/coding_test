package com.example.coding_test.programmers.level1;

public class DivideCharList {

    public int solution(String s) {
        int answer = 0;

        char[] charArray = s.toCharArray();

        int firstCharCount = 1;
        int diffCharCount = 0;
        char currentChar = charArray[0];

        for(int i = 1; i < charArray.length; ++i) {
            if(charArray[i] == currentChar) {
                ++firstCharCount;
            } else {
                ++diffCharCount;
            }

            if(firstCharCount == diffCharCount) {
                ++answer;
                firstCharCount = 0;
                diffCharCount = 0;

                if(i + 1 < charArray.length)
                    currentChar = charArray[i + 1];
            }
        }

        if(firstCharCount != 0)
            ++answer;

        return answer;
    }


}
