package com.example.coding_test.baekjoon;

import java.util.Scanner;
import java.util.Stack;

/**
 * 주소 : https://www.acmicpc.net/problem/17298
 * 문제 : 오큰수
 *
 * 스택에 인덱스를 저장하여 풀이
 */
public class Backjoon17298 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] seq = new int[N];

        for (int i = 0; i < N; i++) {
            seq[i] = in.nextInt();
        }

        Stack<Integer> stack = new Stack<>();


        for(int i = 0; i < N; ++i) {
            while(!stack.isEmpty() && seq[stack.peek()] < seq[i]) {
                seq[stack.pop()] = seq[i];
            }
            // 번호를 넣어라
            stack.push(i);
        }

        while(!stack.isEmpty()){
            seq[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : seq) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
