package study.thursday.week1.YunByungil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = new ArrayList<>();
        int num = Integer.parseInt(br.readLine());
        String test = "" + num;
        for (int i = 0; i < test.length(); i++) {
            numbers.add(test.charAt(i) - '0');
        }
        Collections.sort(numbers, Collections.reverseOrder());
        for (Integer number : numbers) {
            System.out.print(number);
        }

    }
}
