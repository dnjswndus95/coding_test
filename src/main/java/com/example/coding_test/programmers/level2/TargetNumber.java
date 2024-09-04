package com.example.coding_test.programmers.level2;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/43165
 * 문제 : 타겟 넘버
 */

public class TargetNumber {

    static int answer = 0;
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1};
        int target = 2;
        solution(numbers, target);
    }

    public static int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }

    public static void dfs(int[] numbers, int depth, int target, int currentValue) {
        if(depth == numbers.length) {
            if(target == currentValue) {
                ++answer;
            }
            return;
        }

        int plusValue = currentValue + numbers[depth];
        int minusValue = currentValue - numbers[depth];

        dfs(numbers, depth + 1, target, plusValue);
        dfs(numbers, depth + 1, target, minusValue);
    }
}
