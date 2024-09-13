package com.example.coding_test.programmers.level3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DivideN {

    public int solution(int N, int number) {
        if(N == number)
            return 1;

        List<Set<Integer>> dp = new ArrayList<>();

        for(int i = 0; i < 9; ++i) {
            dp.add(new HashSet<>());
        }

        dp.get(1).add(N);


        for(int i = 2; i < 9; ++i) {
            Set<Integer> currentNumbers = dp.get(i);
            StringBuilder sb = new StringBuilder();

            for(int j = 1; j <= i; ++j) {
                sb.append(N);
            }

            for(int j = 1; j <= i; ++j) {
                Set<Integer> beforeNumbers = dp.get(j);
                Set<Integer> afterNumbers = dp.get(i - j);

                for (Integer beforeNumber : beforeNumbers) {
                    for (Integer afterNumber : afterNumbers) {
                        currentNumbers.add(beforeNumber + afterNumber);
                        currentNumbers.add(beforeNumber - afterNumber);
                        currentNumbers.add(beforeNumber * afterNumber);

                        if(afterNumber != 0)
                            currentNumbers.add(beforeNumber / afterNumber);
                    }
                }
            }

            currentNumbers.add(Integer.parseInt(sb.toString()));
        }

        for(int i = 0; i < dp.size(); ++i) {
            if(dp.get(i).contains(number))
                return i;
        }


        return -1;
    }
}
