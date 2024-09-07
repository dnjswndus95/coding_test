package com.example.coding_test.programmers.level1;

import java.util.HashMap;
import java.util.Map;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/12916
 * 문제 : 문자열 내 p와 y의 개수
 */
public class GetPAndY {

    boolean solution(String s) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();

        s = s.toLowerCase();

        for(int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);

            if(ch == 'p')
                map.put("p", map.getOrDefault("p", 0) + 1);
            else if(ch == 'y')
                map.put("y", map.getOrDefault("y", 0) + 1);
        }

        int pNum = map.getOrDefault("p", 0);
        int yNum = map.getOrDefault("y", 0);

        if(pNum == yNum)
            return true;

        return false;
    }
}
