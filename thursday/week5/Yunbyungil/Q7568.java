

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q7568{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rank = new int[n];
        int[][] person = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            person[i][0] = Integer.parseInt(st.nextToken());
            person[i][1] = Integer.parseInt(st.nextToken());
        }

        int count = 0;


        for (int i = 0; i < person.length; i++) {
            for (int j = 0; j < person.length; j++) {
                if (person[i][0] < person[j][0]) {
                    if (person[i][1] < person[j][1]) {
                        count++;
                    }
                }
            }
            rank[i] = count + 1;
            count = 0;
        }
        for (int i : rank) {
            System.out.print(i + " ");
        }
    }
}
