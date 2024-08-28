package com.example.coding_test.programmers.level2;

import java.util.HashMap;
import java.util.Map;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/131127
 * 문제 : 할인 행사
 */

public class DiscountOffer {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<>();
        for(int i = 0; i < want.length; ++i) {
            wantMap.put(want[i], number[i]);
        }

        for(int i = 0; i < discount.length - 9; ++i) {
            Map<String, Integer> discountMap = new HashMap<>();
            boolean isSale = true;

            for (int j = 0; j < 10; ++j) {
                discountMap.put(discount[i + j], discountMap.getOrDefault(discount[i + j], 0) + 1);
            }

            for (String s : wantMap.keySet()) {
                if(wantMap.get(s) != discountMap.get(s)) {
                    isSale = false;
                    break;
                }
            }

            if(isSale)
                ++answer;
        }



        return answer;
    }
}
