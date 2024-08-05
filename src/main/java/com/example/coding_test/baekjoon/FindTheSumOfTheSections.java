package com.example.coding_test.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주소 : https://www.acmicpc.net/problem/11660
 * 문제 : 구간 합 구하기 5
 */
public class FindTheSumOfTheSections {

    public static void main(String[] args) throws IOException {
        System.out.println("Input n, m");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        // (n + 1) x (n + 1) 사이즈
        // n x n 사이즈로 만들었더니 x-1 인덱스를 뺄 수가 없다...
        int[][] sumBoard = new int[n+1][n+1];


        System.out.println("Input board");
        for (int y = 0; y < n; ++y) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int x = 0; x < n; ++x) {
                int num = Integer.parseInt(stringTokenizer.nextToken());
                sumBoard[y+1][x+1] = sumBoard[y][x+1] + sumBoard[y+1][x] - sumBoard[y][x] + num;
            }
        }

        System.out.println("Input y1, x1, y2, x2");
        for (int i = 0; i < m; ++i) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int minY = Integer.parseInt(stringTokenizer.nextToken());
            int minX = Integer.parseInt(stringTokenizer.nextToken());
            int maxY = Integer.parseInt(stringTokenizer.nextToken());
            int maxX = Integer.parseInt(stringTokenizer.nextToken());
            int answer = sumBoard[maxY][maxX] - sumBoard[minY-1][maxX] - sumBoard[maxY][minX-1] + sumBoard[minY-1][minX-1];

            stringBuilder.append(answer);
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
}

