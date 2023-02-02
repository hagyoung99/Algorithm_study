package thursday.week12.jinu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 주차 요금 계산(https://school.programmers.co.kr/learn/courses/30/lessons/92341)
public class ParkingFee {

    public int[] soultion(int[] fees, String[] records) {

        int lastTime = getMin("23:59");
        // 현재 파킹 중인 차들
        Map<String, Integer> parking = new HashMap<>();
        // 차들의 누적 파킹 시간
        Map<String, Integer> times = new HashMap<>();
        // 차들 list
        List<String> cars = new ArrayList<>();

        for (String record : records) {
            String[] rc = record.split(" ");
            int time = getMin(rc[0]);
            String car = rc[1];

            // 새로운 차 등장
            if (!cars.contains(car)) {
                cars.add(car);
                times.put(car, 0);
            }

            if (parking.containsKey(car)) {
                // 현재 주차되어 있는 출차
                times.put(car, times.get(car) + (time - parking.get(car)));
                parking.remove(car);
            } else {
                // 파킹이 안되있으면 입차
                parking.put(car, time);
            }
        }

        int[] ret = new int[cars.size()];

        Collections.sort(cars);

        for (int i = 0; i < cars.size(); i++) {

            // 기본 요금
            ret[i] = fees[1];
            String car = cars.get(i);
            int time = times.get(car) - fees[0];
            if (parking.containsKey(car)) {
                time += (lastTime - parking.get(car));
            }
            if (time > 0) {
                ret[i] += (Math.ceil(time / (fees[2] * 1.0)) * fees[3]);
            }

        }

        return ret;
    }

    public int getMin(String time) {
        String[] t = time.split(":");
        return Integer.valueOf(t[0]) * 60 + Integer.valueOf(t[1]);
    }
}
