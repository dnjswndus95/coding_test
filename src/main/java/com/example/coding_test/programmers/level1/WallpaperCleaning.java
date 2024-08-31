package com.example.coding_test.programmers.level1;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/161990
 * 문제 : 바탕화면 정리
 */
public class WallpaperCleaning {

    public int[] solution(String[] wallpaper) {
        int x = wallpaper.length;
        int y = wallpaper[0].length();

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for(int i = 0; i < x; ++i) {
            for(int j = 0; j < y; ++j) {
                if(wallpaper[i].charAt(j) == '#') {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i + 1);
                    maxY = Math.max(maxY, j + 1);
                }
            }
        }
        int[] answer = {minX, minY, maxX, maxY};

        return answer;
    }
}
