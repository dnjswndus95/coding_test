package com.example.coding_test.programmers.level2;

import java.util.ArrayList;

public class Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize == 0)
            return 5 * cities.length;

        ArrayList<String> cache = new ArrayList<>();

        for(int i = 0; i < cities.length; ++i) {
            String city = cities[i].toLowerCase();

            if(cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                ++answer;
            } else {
                if(cache.size() == cacheSize) {
                    cache.remove(0);
                }

                cache.add(city);
                answer += 5;
            }
        }

        return answer;
    }
}
