package com.example.coding_test.programmers.level1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/12906
 * 문제 : 같은 숫자는 싫어
 */

public class HateSameNumber {

    public static void main(String[] args) {
        solution(new int[]{1,1,3,3,0,1,1});
    }

    public static int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for(int i = 1; i < arr.length; ++i) {
            if(stack.peek() != arr[i])
                stack.push(arr[i]);
        }

        int[] answer = new int[stack.size()];

        for(int i = stack.size() - 1; i >= 0; --i) {
            answer[i] = stack.pop();
        }


        return answer;
    }
}
