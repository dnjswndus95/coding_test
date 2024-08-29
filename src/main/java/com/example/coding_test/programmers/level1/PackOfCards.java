package com.example.coding_test.programmers.level1;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/159994
 * 문제 : 카드 뭉치
 */
public class PackOfCards {

    public static void main(String[] args) {
        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        solution(cards1, cards2, goal);
    }
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0;
        int idx2 = 0;

        for (String s : goal) {
            if(idx1 < cards1.length && cards1[idx1].equals(s))
                ++idx1;
            else if(idx2 < cards2.length && cards2[idx2].equals(s))
                ++idx2;
            else
                return "No";
        }


        return "Yes";
    }
}
