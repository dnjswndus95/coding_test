package com.example.coding_test.programmers.level1;

public class MakeTheDecimal {

    public int solution(int[] nums) {
        int answer = 0;

        for(int i = 0; i < nums.length - 2; ++i) {
            for(int j = i + 1; j < nums.length - 1; ++j) {
                for(int k = j + 1; k < nums.length; ++k) {
                    int num = nums[i] + nums[j] + nums[k];
                    if(checkDecimal(num))
                        ++answer;
                }
            }
        }

        return answer;
    }

    public static boolean checkDecimal(int num) {
        for(int i = 2; i <= Math.sqrt(num); ++i) {
            if(num % i == 0)
                return false;
        }

        return true;
    }
}
