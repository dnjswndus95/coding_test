package com.example.coding_test.programmers.level2;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/68645
 * 문제 : 삼각 달팽이
 */
public class TriangleSnail {


    public static void main(String[] args) {
        int[] solution = solution(1);

        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
    public static int[] solution(int n) {

        if(n == 2)
            return new int[]{1,2,3};
        if(n == 1)
            return new int[]{1};

        int[] counts = new int[n+1];
        counts[2] = 3;

        for(int i = 3; i <= n; ++i) {
            counts[i] = counts[i - 1] + i;
        }

        int size = counts[n];
        int[] answer = new int[size];

        int x = -1;
        int y = 0;
        int value = 1;
        int[][] board = new int[n][n];

        for(int i = 0; i < n; ++i) {
            for(int j = i; j < n; ++j) {
                if(i % 3 == 0) {
                    ++x;
                }
                else if(i % 3 == 1) {
                    ++y;
                }
                else if(i % 3 == 2) {
                    --x;
                    --y;
                }

                board[x][y] = value;
                ++value;
            }
        }

        int idx = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(board[i][j] == 0)
                    break;
                else {
                    answer[idx] = board[i][j];
                    ++idx;
                }
            }
        }

        return answer;
    }
}
