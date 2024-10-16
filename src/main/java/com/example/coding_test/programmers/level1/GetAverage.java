package com.example.coding_test.programmers.level1;

public class GetAverage {

    public double solution(int[] arr) {
        double answer = 0;

        int size = arr.length;

        for (int i : arr) {
            answer += i;
        }

        answer /= size;


        return answer;
    }
}
