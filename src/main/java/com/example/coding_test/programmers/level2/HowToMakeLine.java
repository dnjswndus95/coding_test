package com.example.coding_test.programmers.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/12936
 * 문제 : 줄 서는 방법
 */

public class HowToMakeLine {

    public static void main(String[] args) {
        solution(3, 5);
    }

    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        //k -= 1;

        long count = 1;
        for(int i = 1; i <= n; ++i) {
            list.add(i);
            count *= i;
        }

        int idx = 0;
        while(idx < n) {
            count /= (n - idx);
            answer[idx++] = list.remove( (int) (k / count));
            k %= count;
        }

        return answer;
    }
}
