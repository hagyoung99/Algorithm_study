package jeensung;

import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        for(String now : participant) {
        	hash.put(now, hash.getOrDefault(now, 0) + 1);
        }
        for(String now : completion) {
        	if(hash.containsKey(now)) {
    			hash.put(now, hash.getOrDefault(now, 0) - 1);
    			if(hash.get(now) == 0)
    				hash.remove(now);
        	}
        }
        for(String now : hash.keySet())
        	if(hash.get(now) == 1) {
        		answer = now;
        		break;
        	}
        return answer;
    }
}