package com.example.coding_test.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;


/**
 * 주소 : https://www.acmicpc.net/problem/4358
 * 문제 : 생태학
 * 난이도 : 실버 2
 */
public class Baekjoon4358 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 키 값으로 자동 정렬되는 TreeMap
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        int totalCount = 0;

        String s;
        while((s = br.readLine()) != null) {
            treeMap.put(s, treeMap.getOrDefault(s, 0) + 1);
            ++totalCount;
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            sb.append(entry.getKey())
                    .append(" ")
                    .append(String.format("%.4f", (double)entry.getValue() * 100 / (double)totalCount))
                    .append("\n");
        }

        System.out.println(sb);
    }
}
