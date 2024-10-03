package com.example.coding_test.programmers.kakao;

import java.util.Stack;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/64061
 * 문제 : 크레인 인형뽑기 게임
 *
 */

public class CraneDollMachine {

    public static void main(String[] args) {
        int[][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(board.length);
        System.out.println(board[0].length);

        int solution = solution(board, moves);
        System.out.println("answer ===> " + solution);
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> bucket = new Stack<>();
        bucket.push(0);

        for(int i = 0; i < moves.length; ++i) {
            // 어떤 bucket인지 계산
            int idx = moves[i] - 1;

            for(int j = 0; j < board.length; ++j) {
                if(board[j][idx] != 0) {
                    // 인형 뽑아서 제거
                    int doll = board[j][idx];
                    board[j][idx] = 0;

                    if(bucket.peek() == doll) {
                        bucket.pop();
                        answer += 2;
                    } else {
                        bucket.push(doll);
                    }

                    break;
                }
            }
        }
        return answer;
    }
}
