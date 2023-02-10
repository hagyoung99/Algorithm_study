package thursday.week14.hagyoung;

import java.util.Map;
import java.util.HashMap;
public class P42578 {
    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(String[] x: clothes){
            map.put(x[1], map.getOrDefault(x[1], 0)+1);
        }

        for(String key: map.keySet()){
            answer *= (map.get(key)+1);
        }

        return answer-1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(solution(new String[][] {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }
}
