package ?•ë ¬.silver.no18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> ranking = new HashMap<>();
        int rank = 0;

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[] sortedNum = new int[n];

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            sortedNum[i] = num[i];
        }
        Arrays.sort(sortedNum);

        for (int i = 0; i < n; i++) {
            if(!ranking.containsKey(sortedNum[i])) {
                ranking.put(sortedNum[i], rank);
                rank++;
            }
        }

        for (int i : num) {
            sb.append(ranking.get(i)).append(" ");
        }
        System.out.println(sb);

    }
}
