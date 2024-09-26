package com.example.coding_test.programmers.level2;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/160585
 * 문제 : 혼자서 하는 틱택토
 */
public class TicTakTo {
    public int solution(String[] board) {

        int xCount = 0;
        int oCount = 0;

        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[i].length(); ++j) {
                if(board[i].charAt(j) == 'X')
                    ++xCount;
                else if(board[i].charAt(j) == 'O')
                    ++oCount;
            }
        }

        // x는 o보다 많을 수는 없다.
        if(xCount > oCount)
            return 0;

        // o는 x보다 2개 이상 많을 수 없다.
        if(oCount > xCount + 1)
            return 0;

        if(isWin(board, 'X') && xCount != oCount)
            return 0;

        if(isWin(board, 'O') && oCount != xCount + 1)
            return 0;

        return 1;
    }

    public static boolean isWin(String[] board, char player) {

        for(int i = 0; i < 3; ++i) {
            if(board[i].charAt(0) == player
                && board[i].charAt(1) == player
                && board[i].charAt(2) == player) {
                return true;
            }
        }

        for(int i = 0; i < 3; ++i) {
            if(board[0].charAt(i) == player
                && board[1].charAt(i) == player
                && board[2].charAt(i) == player) {
                return true;
            }
        }

        if(board[0].charAt(0) == player
            && board[1].charAt(1) == player
            && board[2].charAt(2) == player)
            return true;

        if(board[0].charAt(2) == player
            && board[1].charAt(1) == player
            && board[2].charAt(0) == player)
            return true;

        return false;
    }
}
