package com.example.coding_test.programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/152996
 * 문제 : 시소 짝꿍
 */
public class SeesawPair {

    public long solution(int[] weights) {
        long answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < weights.length; ++i) {
            map.put(weights[i], map.getOrDefault(weights[i], 0) + 1);
        }

        int[] weightArr = new int[map.size()];
        int[] countArr = new int[map.size()];

        int idx = 0;
        for (Integer key : map.keySet()) {
            weightArr[idx] = key;
            countArr[idx] = map.get(key);
            idx++;
        }


        for(int i = 0; i < weightArr.length; ++i) {
            if(countArr[i] > 1)
                answer += (long) countArr[i] * (countArr[i] - 1) / 2;

            for(int j = i + 1; j < weightArr.length; ++j) {
                if (isPair(weightArr[i], weightArr[j])) {
                    answer += (long) countArr[i] * countArr[j];
                }
            }
        }


        return answer;
    }

    public static boolean isPair(int w1, int w2) {
        if( w1 == w2 * 2
            || w1 * 2 == w2 * 3
            || w1 * 3 == w2 * 4
            || w1 * 2 == w2
            || w1 * 3 == w2 * 2
            || w1 * 4 == w2 * 3)
            return true;


        return false;
    }
}
