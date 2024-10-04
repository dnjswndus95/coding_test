package com.example.coding_test.programmers.PCCE;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/250125
 * 문제 : 이웃한 칸
 */
public class NeighboringBlock {
    public static void main(String[] args) {
        String[][] board = {
                {"blue",     "red",      "orange",   "red"},
                {"red",      "red",      "blue",     "orange"},
                {"blue",     "orange",   "red",      "red"},
                {"orange",   "orange",   "red",      "blue"}
        };
        int h = 1;
        int w = 1;
        solution(board, h, w);
    }

    public static int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dw = { 0, 1, -1, 0};
        int[] dh = { 1, 0, 0, -1};
        int size = board.length;


        for(int i = 0; i < 4; ++i) {
            if( 0 <= h + dh[i] &&
                    h + dh[i] < size &&
                    0 <= w + dw[i] &&
                    w + dw[i] < size) {
                if(board[h][w].equals(board[h+dh[i]][w+dw[i]]))
                    ++answer;
            }
        }

        return answer;
    }
}
