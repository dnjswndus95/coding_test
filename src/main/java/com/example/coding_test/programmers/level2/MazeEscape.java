package com.example.coding_test.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/159993
 * 문제 : 미로 탈출
 */
public class MazeEscape {

    public static void main(String[] args) {
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        System.out.println(solution(maps));
    }

    static int n = 0;
    static int m = 0;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static int solution(String[] maps) {
        int answer = 0;

        int startX = 0;
        int startY = 0;
        int leverX = 0;
        int leverY = 0;

        n = maps.length;
        m = maps[0].length();

        String[][] map = new String[n][m];

        for(int i = 0; i < n; ++i) {
            String[] temp = maps[i].split("");
            for(int j = 0; j < m; ++j) {
                map[i][j] = temp[j];

                if(temp[j].equals("S")) {
                    startX = i;
                    startY = j;
                } else if(temp[j].equals("L")) {
                    leverX = i;
                    leverY = j;
                }
            }
        }

        int leverDistance = bfs(map, startX, startY, "L");

        if(leverDistance == -1)
            return -1;

        int exitDistance = bfs(map, leverX, leverY, "E");

        if(exitDistance == -1)
            return -1;

        answer = leverDistance + exitDistance;

        return answer;
    }

    public static int bfs(String[][] map, int x, int y, String target) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        boolean[][] visited = new boolean[n][m];
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] head = q.poll();
            int cx = head[0];
            int cy = head[1];
            int count = head[2];

            if(map[cx][cy].equals(target)) {
                return count;
            }

            for(int i = 0; i < 4; ++i) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(inRange(nx, ny) && !map[nx][ny].equals("X") && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, count + 1});
                }
            }
        }

        return -1;
    }

    public static boolean inRange(int x, int y) {
        return (x >= 0 && y >= 0 && x < n && y < m);
    }

}

// 주저리 고민
// 레버까지 bfs로 탐색하고 레버서부터 출구까지 bfs한걸 더하자...
// 둘 중 하나라도 찾지 못하면 -1 리턴
