import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            String str = clothes[i][1];
            hashMap.put(str, hashMap.getOrDefault(str, 0) + 1);
        }
        for(String key : hashMap.keySet()){
            answer *= hashMap.get(key) + 1;
        }
        return answer - 1;
    }
}