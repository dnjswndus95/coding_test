package com.example.coding_test.programmers.level2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/154540
 * 문제 : 무인도 여행
 */
public class IslandTravel {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int day = 0;
    public static void main(String[] args) {
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        int[] answer = solution(maps);

        for (int i : answer) {
            System.out.println(i);
        }
    }

    public static int[] solution(String[] maps) {
        boolean[][] isVisited = new boolean[maps.length][maps[0].length()];
        int[][] map = new int[maps.length][maps[0].length()];
        ArrayList<Integer> days = new ArrayList<>();

        // 바다는 0
        // 섬은 int 숫자로 변환
        for(int i = 0; i < maps.length; ++i) {
            char[] row = maps[i].toCharArray();
            for(int j = 0; j < maps[i].length(); ++j) {
                if(row[j] == 'X')
                    map[i][j] = 0;
                else
                    map[i][j] = row[j] - '0';
            }
        }

        for(int x = 0; x < map.length; ++x) {
            for(int y = 0; y < map[x].length; ++y) {
                if(!isVisited[x][y] && map[x][y] > 0) {
                    dfs(map, isVisited, x, y);
                    days.add(day);
                    day = 0;
                }
            }
        }

        if(days.isEmpty())
            return new int[]{-1};

        Collections.sort(days);

        int[] answer = new int[days.size()];
        for(int i = 0; i < days.size(); ++i) {
            answer[i] = days.get(i);
        }

        return answer;
    }

    public static void dfs(int[][] map, boolean[][] isVisited, int x, int y) {
        day += map[x][y];
        isVisited[x][y] = true;

        for(int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 맵 밖이 아닌 것만 탐색
            if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[x].length) {
                // 방문하지 않았고 섬이라면
                if(!isVisited[nx][ny] && map[nx][ny] > 0) {
                    dfs(map, isVisited, nx, ny);
                }
            }
        }
    }
}
