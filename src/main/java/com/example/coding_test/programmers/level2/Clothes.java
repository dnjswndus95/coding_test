package com.example.coding_test.programmers.level2;

import java.util.HashMap;
import java.util.Map;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/42578
 * 이름 : 의상
 */
public class Clothes {

    public static void main(String[] args) {
        String[][] clothes = {{"crow_mask", "1"}, {"blue_sunglasses", "2"}, {"smoky_makeup", "3"}, {"zzz", "4"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < clothes.length; ++i) {
            Integer num = map.get(clothes[i][1]);

            /**
             *  밑 부분을 put(getOrDefault) 로 사용했다면 더 깔끔한 코드가 되었을것..
             */
            if (num != null) {
                map.put(clothes[i][1], ++num);
            } else {
                map.put(clothes[i][1], 1);
            }
        }

        for (Integer value : map.values()) {
            answer *= value + 1;
        }

        return answer - 1;
    }
}
