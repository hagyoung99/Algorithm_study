package 프로그래머스.Level2.위장;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
//        String[][] clothes = {
//                {"yellow_hat", "headgear"},
//                {"blue_sunglasses", "eyewear"},
//                {"green_turban", "headgear"}
//        };
        String[][] clothes = {
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}
        };

        Map<String, Integer> map = new HashMap<>();
        int answer = 1;

        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        for (Integer value : map.values()) {
            answer *= (value + 1);
        }

        System.out.println(answer -  1);
    }
}
