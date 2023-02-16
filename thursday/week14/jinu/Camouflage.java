package thursday.week14.jinu;

import java.util.HashMap;

// 위장(https://school.programmers.co.kr/learn/courses/30/lessons/42578)
public class Camouflage {

    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hash = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String cloth_type = clothes[i][1];
            hash.put(cloth_type, hash.getOrDefault(cloth_type, 1) + 1);
        }

        for (String key : hash.keySet()) {
            answer *= hash.get(key);
        }

        return answer - 1;
    }

}
