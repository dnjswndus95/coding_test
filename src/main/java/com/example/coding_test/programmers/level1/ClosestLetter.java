package com.example.coding_test.programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClosestLetter {

    public static void main(String[] args) {
        solution("banana");
    }

    public static int[] solution(String s) {
        ArrayList<Integer> answerList = new ArrayList<>();
        char[] charArray = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        map.put(charArray[0], 0);
        answerList.add(-1);

        for(int i = 1; i < charArray.length; ++i) {

            if(!map.containsKey(charArray[i])) {
                answerList.add(-1);
            } else {
                answerList.add(i - map.get(charArray[i]));
            }

            map.put(charArray[i], i);
        }

        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); ++i) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
