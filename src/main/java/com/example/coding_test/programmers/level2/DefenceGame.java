package com.example.coding_test.programmers.level2;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class DefenceGame {

    public static void main(String[] args) {
        int[] enemy = {3, 3, 3, 3};

        int answer = solution(2, 4, enemy);
    }

    public static int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int temp = k;
        Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < enemy.length; ++i) {
            n -= enemy[i];
            priorityQueue.add(enemy[i]);

            // 적이 아군보다 많은 경우
            if(n < 0) {
                // 무적권이 있고
                // 해치운 적이 있다면
                if(k > 0 && !priorityQueue.isEmpty()) {
                    // 적이 가장 많은 웨이브를 무적권으로 대체
                    n += priorityQueue.poll();
                    --k;
                } else {
                    answer = i;
                    break;
                }
            }
        }

        if(answer == 0)
            answer = enemy.length;

        return answer;
    }
}
