package com.example.coding_test.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 주소 : https://www.acmicpc.net/problem/1926
 * 문제 : 그림
 */
public class Baekjoon1926 {

    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static int extent = 0;
    static int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        List<Integer> answer = new ArrayList<>();
        boolean zeroFlag = true;


        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j) {
                graph[n][m] = sc.nextInt();
                if(graph[n][m] == 1)
                    zeroFlag = false;
            }
        }

        if(zeroFlag) {
            System.out.println(0);
            System.out.println(0);
            return;
        }


        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                extent = 0;
                if(!visited[i][j] && graph[i][j] == 1) {
                    dfs(i, j);
                    answer.add(extent);
                }
            }
        }

        Collections.sort(answer);

        System.out.println(answer.size());
        System.out.println(answer.get(answer.size() - 1));
    }

    public static void dfs(int x, int y) {
        // 이중 for문을 돌면서 1이 나올때마다 BFS 실행
        // 값이 1이여야 하고 방문이 안되어 있는 곳에서만 BFS 실행
        // BFS를 돌면서 그림 개수 +1, 최대값을 갱신한다.

        visited[x][y] = true;
        extent++;

        for(int i = 0; i < directions.length; ++i) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[n][m] && graph[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

}
