package com.example.coding_test.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/169199
 * 이름 : 리코쳇 로봇
 *
 * 풀이 : BFS를 이용하여 풀이
 */
public class RicochetRobot {

    public static void main(String args[]) {
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        solution(board);
    }

    public static int solution(String[] board) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0 , 0, 1, -1};


        int[] start = new int[2];
        int n = board.length;
        int m = board[0].length();
        String[][] map = new String[n][m];
        boolean[][] isVisited = new boolean[n][m];

        // map 2차원 배열로 세팅
        for(int i = 0; i < n; ++i) {
            String[] temp = board[i].split("");

            for(int j = 0; j < m; ++j) {
                map[i][j] = temp[j];

                if(temp[j].equals("R")) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});
        isVisited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] q = queue.poll();
            int x = q[0];
            int y = q[1];
            int count = q[2];

            if(map[x][y].equals("G"))
                return count;

            for(int i = 0; i < 4; ++i) {
                int nx = x;
                int ny = y;

                while(nx >= 0 && ny >= 0 && nx < n && ny < m && !map[nx][ny].equals("D")) {
                    nx += dx[i];
                    ny += dy[i];
                }

                nx -= dx[i];
                ny -= dy[i];

                if(isVisited[nx][ny] || (x == nx && y == ny)) continue;

                isVisited[nx][ny] = true;
                queue.add(new int[]{nx, ny, count + 1});
            }
        }

        return -1;


        /*// bfs 탐색
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});
        isVisited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] q = queue.poll();
            int x = q[1];
            int y = q[0];
            int count = q[2];

            if(map[y][x] == "G")
                return count;

            for(int i = 0; i < 4; ++i) {
                int nx = x;
                int ny = y;

                while(x >= 0 && y >= 0 && x < m && y < n && board[ny].charAt(nx) != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }

                nx -= dx[i];
                ny -= dy[i];

                if(isVisited[ny][nx] || (x == nx && y == ny)) continue;



                isVisited[ny][nx] = true;
                queue.add(new int[]{nx, ny, count + 1});
            }
        }

        return -1;*/
    }

}
