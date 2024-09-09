package com.example.coding_test.programmers.level1;

import java.util.HashMap;
import java.util.Map;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/1845
 * 문제 : 포켓몬
 *
 * 아이디어
 * 1. 포켓몬을 일단 HashMap으로 관리해서 포켓몬마다 몇마리가 있는지 구하자
 */
public class PocketMonster {

    public int solution(int[] nums) {
        int answer = 0;

        Map<Integer, Integer> monsterMap = new HashMap<>();

        for(int i = 0; i < nums.length; ++i) {
            monsterMap.put(nums[i], monsterMap.getOrDefault(nums[i], 0) + 1);
        }

        int pocketMonsterKindNum = monsterMap.size();
        int pickNum = nums.length/2;

        return Math.max(pocketMonsterKindNum, pickNum);
    }
}
