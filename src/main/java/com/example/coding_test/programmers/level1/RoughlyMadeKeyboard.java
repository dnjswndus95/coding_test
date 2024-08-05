package com.example.coding_test.programmers.level1;

/**
 *  주소 : https://school.programmers.co.kr/learn/courses/30/lessons/160586
 *  이름 : 대충 만든 자판
 */
public class RoughlyMadeKeyboard {

    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD", "AABB"};
        int[] solution = solution(keymap, targets);

    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        // targets 배열에서 원소 하나씩 추출
        for (int i = 0; i < targets.length; ++i) {
            String target = targets[i];
            // target에서 한글자씩 추출
            for (char c : target.toCharArray()){
                int minCount = Integer.MAX_VALUE;
                for (String s : keymap) {
                    int count = s.indexOf(c);
                    if(minCount > count && count != -1)
                        minCount = s.indexOf(c);
                }

                if(minCount < Integer.MAX_VALUE && answer[i] != -1)
                    answer[i] += minCount + 1;
                else
                    answer[i] = -1;
            }

        }

        return answer;
    }
}
