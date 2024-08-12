package com.example.coding_test.programmers.level1;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/250137
 * 문제 : 붕대감기
 */
public class Bandage {

    public static void main(String[] args) {
        int[] bandage = new int[]{3, 2, 7};
        int[][] attacks = new int[][]{{1, 15}, {5, 16}, {8, 6}};
        int health = 20;

        solution(bandage, health, attacks);
    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int skillTime = bandage[0];
        int recoveryPerSec = bandage[1];
        int bonusRecovery = bandage[2];
        int idx = 0;
        int recoveryNum = 0;
        int answer = health;

        for(int i = 1; i <= attacks[attacks.length-1][0]; ++i) {
            // 공격
            if(i == attacks[idx][0]) {
                answer -= attacks[idx][1];
                recoveryNum = 0;
                ++idx;
            } else {
                // 붕대 회복
                answer += recoveryPerSec;
                ++recoveryNum;

                if(recoveryNum == skillTime) {
                    answer += bonusRecovery;
                    recoveryNum = 0;
                }

                if(answer > health)
                    answer = health;
            }

            System.out.println("health ======> " + answer);

            // 0 이하 -1 리턴
            if(answer <= 0)
                return -1;
        }

        return answer;
    }
}
