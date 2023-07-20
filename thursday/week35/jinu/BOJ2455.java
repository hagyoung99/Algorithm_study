package thursday.week35.jinu;

import java.io.*;
import java.util.*;

public class BOJ2455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int now = 0;
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());
            now -= out;
            now += in;
            max = Math.max(max, now);
        }
        System.out.print(max);
    }
}
