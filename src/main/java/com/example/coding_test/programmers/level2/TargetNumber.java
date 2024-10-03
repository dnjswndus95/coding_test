package com.example.coding_test.programmers.level2;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/43165
 * 문제 : 타겟 넘버
 */

public class TargetNumber {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1};
        int target = 1;
        solution(numbers, target);
    }

    public static int solution(int[] numbers, int target) {
        int answer = 1;
        // depth를 전달하니까 for문은 필요없음.
        answer = dfs(numbers, 0, target, 0);
        return answer;
    }

    public static int dfs(int[] numbers, int depth, int target, int value) {
        if(depth == numbers.length) {
            if (target == value) {
               return 1;
            }
            return 0;
        }

        return dfs(numbers, depth + 1, target, value + numbers[depth]) + dfs(numbers, depth + 1, target, value - numbers[depth]);
    }

}
