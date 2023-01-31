package cod;
import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int x1 = fees[0];
        int x2 = fees[1];
        int x3 = fees[2];
        int x4 = fees[3];
        int index = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        HashMap<Integer, Integer> list = new HashMap<>();
        HashMap<Integer, Integer> real = new HashMap<>();
        while(index < records.length){
            int hour = Integer.parseInt(records[index].substring(0, 2));
            int min = Integer.parseInt(records[index].substring(3, 5));
            int time = min + (hour * 60);
            int number = Integer.parseInt(records[index].substring(6, 10));
            if(records[index].charAt(11) == 'I'){
                hashMap.put(number,  time);
            }else{
                int temp = time - hashMap.get(number);
                hashMap.remove(number);
                real.put(number, real.getOrDefault(number, 0) + temp);
            }
            index++;
        }
    	Iterator<Integer> iter = hashMap.keySet().iterator();
    	while(iter.hasNext()) {
    		int x = iter.next();
    		int fullTime = 60 * 24 - 1;
    		int time = fullTime - hashMap.get(x);
			real.put(x, real.getOrDefault(x, 0) + time);
    	}

        Iterator<Integer> it = real.keySet().iterator();
        while(it.hasNext()) {
        	int x = it.next();
    		if(real.get(x) <= x1) {
    			list.put(x, list.getOrDefault(x, 0) + x2);
    		}else {
    			int c = real.get(x) - x1;
    			int pp = c / x3;
    			if(c % x3 > 0)
    				pp += 1;
    			int dollar = x2 + (x4 * pp);
    			list.put(x, list.getOrDefault(x, 0) + dollar);
    		}
        }
        int[] answer = new int[list.size()];
        ArrayList<Integer> aList = new ArrayList<Integer>(list.keySet());
        Collections.sort(aList);
        for(int i = 0; i < list.size(); i++)
        	answer[i] = list.get(aList.get(i));
        return answer;
    }
}