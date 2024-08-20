package com.example.coding_test.programmers.kakao;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/118667
 * 문제 : 2022 KAKAO TECH INTERNSHIP > 두 큐 합 같게 만들기
 */
public class MakeSumOfTwoQueueEqual {

    public static void main(String[] args) {
        int[] queue1 = {1, 1};
        int[] queue2 = {1, 5};
        solution(queue1, queue2);
    }
    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Long sum1 = 0L;
        Long sum2 = 0L;

        for(int i = 0; i < queue1.length; ++i) {
            sum1 += queue1[i];
            sum2 += queue2[i];
        }

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i = 0; i < queue1.length; ++i) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        while(sum1 != sum2) {
            if(answer > (queue1.length + queue2.length) * 2)
                return -1;

            if(sum1 > sum2) {
                Integer value = q1.poll();
                q2.add(value);
                sum1 -= value;
                sum2 += value;
            } else if (sum1 < sum2) {
                Integer value = q2.poll();
                q1.add(value);
                sum1 += value;
                sum2 -= value;
            } else
                return answer;

            ++ answer;
        }

        return answer;
    }
}
