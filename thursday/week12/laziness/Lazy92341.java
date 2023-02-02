package thursday.week12.laziness;

import java.util.*;

public class Lazy92341 {
    public static int[] solution(int[] fees, String[] records) {
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> ans = new TreeMap<>(Comparator.comparingInt(Integer::parseInt));

        for (int i = 0; i < records.length; i++) {
            String time = records[i].split(" ")[0];
            String carNumber = records[i].split(" ")[1];
            String state = records[i].split(" ")[2];

            if (state.equals("IN")) {
                map.put(carNumber, time);
                continue;
            }

            int min = getMin(time, map.get(carNumber));

            ans.put(carNumber, ans.getOrDefault(carNumber, 0) + min);
            map.remove(carNumber);
        }

        if (!map.isEmpty()) {
            for (String carNumber : map.keySet()) {
                int min = getMin("23:59", map.get(carNumber));
                ans.put(carNumber, ans.getOrDefault(carNumber, 0) + min);
            }
        }

        return getAnswer(ans, fees);
    }

    private static int[] getAnswer(Map<String, Integer> ansMap, int[] fees) {
        List<Integer> ans = new ArrayList<>();

        for (String carNumber : ansMap.keySet()) {
            int min = ansMap.get(carNumber);
            int fee = 0;

            if (min <= fees[0]) fee += fees[1];
            else fee += (((int) Math.ceil(((double)min - fees[0]) / fees[2])) * fees[3]) + fees[1];

            ans.add(fee);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int getMin(String outTime, String inTime) {
        int t1 = Integer.parseInt(outTime.split(":")[0]) * 60 + Integer.parseInt(outTime.split(":")[1]);
        int t2 = Integer.parseInt(inTime.split(":")[0]) * 60 + Integer.parseInt(inTime.split(":")[1]);
        
        return t1 - t2;
    }
}
