package com.example.coding_test.programmers.level1;

import java.util.Stack;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/134240
 * 문제 : 푸드 파이트 대회
 */
public class FoodFight {

    public static void main(String[] args) {
        int[] food = {1, 7, 1, 2};
        String solution = solution(food);
        System.out.println(solution);
    }

    public static String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for(int i = 1; i < food.length; ++i) {
            int count = food[i];
            if(count/2 >= 1) {
                for(int j = 0; j < count/2; ++j) {
                    sb.append(i);
                    stack.push(i);
                }
            }
        }

        sb.append(0);
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
