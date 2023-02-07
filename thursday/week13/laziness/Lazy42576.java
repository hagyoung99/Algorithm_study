package thursday.week13.laziness;

import java.util.*;

public class Lazy42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : participant) map.put(s, map.getOrDefault(s, 0) + 1);
        for(String s : completion) map.put(s, map.get(s) - 1);
        for(Map.Entry<String, Integer> item : map.entrySet()) {
            if(item.getValue() == 1) return item.getKey();
        }
        return answer;
    }
}
