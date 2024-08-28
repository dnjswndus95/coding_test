package com.example.coding_test.programmers.level1;

import java.util.HashMap;
import java.util.Map;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/178871
 * 문제 : 달리기 경주
 */
public class RunningRace {

    public static void main(String[] args) {

    }
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> raceMap = new HashMap<>();

        for(int i = 0; i < players.length; ++i) {
            raceMap.put(players[i], i);
        }

        for (String call : callings) {
            Integer calledRank = raceMap.get(call);

            // map에서 순위를 찾고 인덱스를 찾았으니
            // 배열로 조작하는게 좋다...
            String reversalPlayer = players[calledRank];
            String reversedPlayer = players[calledRank - 1];

            players[calledRank] = reversedPlayer;
            players[calledRank - 1] = reversalPlayer;

            raceMap.put(reversalPlayer, calledRank - 1);
            raceMap.put(reversedPlayer, calledRank);
        }

        return players;
    }
}
