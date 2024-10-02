package com.example.coding_test.programmers.level1;

import java.util.HashMap;
import java.util.Map;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/176963
 * 이름 : 추억 점수
 */

public class MemoryScore {

    public static void main(String args[]) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photos = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        solution(name, yearning, photos);
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photos) {
        int[] answer = new int[photos.length];

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < name.length; ++i) {
            map.put(name[i], yearning[i]);
        }

        for(int i = 0; i < photos.length; ++i) {
            for(int j = 0; j < photos[i].length; ++j) {
                answer[i] += map.getOrDefault(photos[i][j], 0);
            }
        }

        return answer;
    }
}
