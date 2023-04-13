package b전체문제.실버.수이어가기_2635;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReMain {
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int count = 0;

        List<Integer> result = new ArrayList<>();

        for (int i = n; i >= n / 2; i--) {
            List<Integer> list = new ArrayList<>();
            list.add(n);
            list.add(i);

            int m = n;
            int n2 = i;

            while (true) {
                int answer = m - n2;
                if (answer < 0) {
                    break;
                }

                if (answer >= 0) {
                    list.add(answer);
                }
                m = n2;
                n2 = answer;

            }

            if (count < list.size()) {
                count = list.size();
                result = list;
            }

        }
        System.out.println(count);
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }

    }
}
