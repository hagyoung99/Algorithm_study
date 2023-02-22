package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BeakJoon18870 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>();

        int origin[] = new int[n];
        int sorted[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);
        int rank = 0;
        for (int value : sorted) {
            if (!rankingMap.containsKey(value)) {
                rankingMap.put(value, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int key : origin) {
            int ranking = rankingMap.get(key);
            sb.append(ranking).append(' ');
        }
        System.out.println(sb);
    }
}
