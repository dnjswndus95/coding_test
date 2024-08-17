package com.example.coding_test.programmers.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/155651
 * 문제 : 호텔 대실
 */

public class StayTheHotelRoom {

    public static void main(String[] args) {
        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        solution(book_time);
    }

    // 1860
    public static int solution(String[][] book_time) {
        int[][] bookTime = new int[book_time.length][2];

        for(int i = 0; i < book_time.length; ++i) {
            int start = Integer.parseInt(book_time[i][0].replace(":", ""));
            int end = Integer.parseInt(book_time[i][1].replace(":", "")) + 10;

            if(end % 100 >= 60) {
                end += 40;
            }

            bookTime[i][0] = start;
            bookTime[i][1] = end;
        }

        Arrays.sort(bookTime, (a1, a2) -> {
            return a1[0] - a2[0];
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        for (int[] time : bookTime) {
            if(pq.isEmpty()) {
                pq.add(time);
            } else {
                int[] temp = pq.peek();
                int end = temp[1];

                if(time[0] >= end)
                    pq.poll();

                pq.add(time);
            }
        }
        return pq.size();
    }
}
