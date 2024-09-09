package com.example.coding_test.programmers.level1;

import java.util.Stack;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/133502
 * 문제 : 햄버거 만들기
 *
 * 아이디어
 * 1. {1, 2, 3, 1}이 있어야 햄버거 하나를 만들 수 있다.
 */
public class MakeTheHamburger {

    public static void main(String[] args) {
        int solution = solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2});
        System.out.println("answer ==> " + solution);
    }

    public static int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < ingredient.length; ++i) {
            stack.push(ingredient[i]);

            if(stack.size() >= 4) {
                if(stack.get(stack.size()-4) == 1 &&
                        stack.get(stack.size()-3) == 2 &&
                        stack.get(stack.size()-2) == 3 &&
                        stack.get(stack.size()-1) == 1) {
                    ++answer;
                    for(int j = 0; j < 4; ++j){
                        stack.pop();
                    }
                }
            }
        }

        return answer;
    }
}
