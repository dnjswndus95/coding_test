package com.example.coding_test.programmers.level2;

import java.util.*;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/138476
 * 문제 : 귤 고르기
 */
public class PickUpTheMandarin {

    /**
     * 우선순위 큐는 항상 정렬상태를 유지해야 하므로
     * 리스트로 한번에 넣고 정렬을 하는게 성능적으로 유리하다.
     * 우선순위 큐에서 정렬된 순서로 요소를 꺼내오는 것은 O(log n) 추가비용이 발생한다
     * 리스트 쓰자...
     */

    public static void main(String[] args) {
        int[] tangerine = new int[]{1, 3, 2, 5, 4, 5, 2, 3};

        int solution = solution(6, tangerine);
        System.out.println(solution);
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int tangerineSize: tangerine) {
            map.put(tangerineSize, map.getOrDefault(tangerineSize, 0) + 1);
        }

        for (Integer value : map.values()) {
            queue.add(value);
        }

        while(!queue.isEmpty()) {
            if(k <= queue.peek()) {
                ++answer;
                break;
            }

            k -= queue.poll();
            ++answer;
        }

        return answer;
    }
}


