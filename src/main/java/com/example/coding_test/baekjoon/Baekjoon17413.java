package com.example.coding_test.baekjoon;

import java.util.Scanner;
import java.util.Stack;

/**
 * 주소 : https://www.acmicpc.net/problem/17413
 * 문제 : 단어 뒤집기 2
 */
public class Baekjoon17413 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean tagFlag = false;

        for(int i = 0; i < s.length(); ++i) {
            char cs = s.charAt(i);

            // 태그 처리
            if(cs == '<') {
                while(!stack.isEmpty()) {
                    answer.append(stack.pop());
                }
                tagFlag = true;
                answer.append(cs);
            } else if(cs == '>') {
                tagFlag = false;
                answer.append(cs);
            } else if(tagFlag) {
                answer.append(cs);
            } else if(!tagFlag){
                if(cs == ' ') {
                    while(!stack.isEmpty()) {
                        answer.append(stack.pop());
                    }
                    answer.append(' ');
                } else {
                    stack.push(cs);
                }
            }
        }

        while(!stack.isEmpty()) {
            answer.append(stack.pop());
        }

        System.out.println(answer);
    }
}
