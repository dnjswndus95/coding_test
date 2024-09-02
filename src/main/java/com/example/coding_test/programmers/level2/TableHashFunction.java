package com.example.coding_test.programmers.level2;

import java.util.Arrays;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/147354
 * 문제 : 테이블 해시 함수
 */

public class TableHashFunction {


    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, (d1, d2) -> {
          if(d1[col - 1] == d2[col - 1]) {
              return d2[0] - d1[0];
          } else {
              return d1[col - 1] - d2[col - 1];
          }
        });


        for(int i = row_begin - 1; i < row_end; ++i) {
            int temp = 0;
            for(int j = 0; j < data[i].length; ++j) {
                temp += data[i][j] % (i + 1);
            }
            answer = answer ^ temp;
        }


        return answer;
    }
}
