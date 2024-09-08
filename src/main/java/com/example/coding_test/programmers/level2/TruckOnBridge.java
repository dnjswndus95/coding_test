package com.example.coding_test.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/42583
 * 문제 : 다리를 지나는 트럭
 *
 * 아이디어
 * 1. queue를 이용해보자
 * 2. 트럭을 실을 순 없을 때 0을 넣는다
 * 3. 그리고 q가 다 비워질떄까지 while문을 돌리며 시간을 증가시킨다.
 */

public class TruckOnBridge {

    public static void main(String[] args) {
        int solution = solution(2, 10, new int[]{7, 4, 5, 6});
        System.out.println("answer ====> " + solution);
    }


    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;

        Queue<Integer> q = new LinkedList<>();

        int idx = 1;

        for(int i = 0; i < bridge_length - 1; ++i)
            q.add(0);

        int totalWeight = truck_weights[0];
        q.add(totalWeight);

        while(!q.isEmpty()) {
            ++answer;
            Integer removedWeight = q.poll();
            totalWeight -= removedWeight;

            if(idx < truck_weights.length) {
                if(totalWeight + truck_weights[idx] <= weight) {
                    q.add(truck_weights[idx]);
                    totalWeight += truck_weights[idx];
                    ++idx;
                } else {
                    q.add(0);
                }
            }
        }


        return answer;
    }
}
