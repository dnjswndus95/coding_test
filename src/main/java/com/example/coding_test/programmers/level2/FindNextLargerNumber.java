package com.example.coding_test.programmers.level2;

import java.util.Arrays;
import java.util.Stack;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/154539
 * 이름 : 뒤에 있는 큰 수 찾기
 */
public class FindNextLargerNumber {

    public static void main(String[] args) {

    }

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 0; i < numbers.length; ++i) {
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                answer[stack.pop()] = numbers[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}
