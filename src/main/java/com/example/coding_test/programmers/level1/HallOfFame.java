package com.example.coding_test.programmers.level1;

import java.util.*;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/138477
 * 문제 : 명예의 전당(1)
 */
public class HallOfFame {

    public int[] solution(int k, int[] score) {
        int size = score.length;

        int[] answer = new int[size];

        List<Integer> fameList = new LinkedList<>();

        for(int i = 0; i < size; ++i) {
            if(fameList.size() < k) {
                fameList.add(score[i]);
            } else {
                if(fameList.get(0) < score[i])
                    fameList.set(0, score[i]);
            }

            Collections.sort(fameList);
            answer[i] = fameList.get(0);
        }


        return answer;
    }

    /*
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i = 0; i < score.length; i++) {

            priorityQueue.add(score[i]);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }

            answer[i] = priorityQueue.peek();
        }



        return answer;
    }
     */
}
