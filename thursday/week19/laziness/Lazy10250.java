package thursday.week19.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lazy10250 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(reader.readLine());

        for(int caseNum = 0 ; caseNum < T ; caseNum++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            sb.append(getRoomNum(h, w, n)).append("\n");
        }
        System.out.println(sb);
    }

    private static String getRoomNum(int h, int w, int n) {
        String answer = "";
        boolean isTop = n % h == 0;
        answer += (isTop ? h : n % h);
        answer += (isTop ? n / h : n / h + 1) < 10 ? "0" + (isTop ? n / h : n / h + 1) : (isTop ? n / h : n / h + 1);
        return answer;
    }
}