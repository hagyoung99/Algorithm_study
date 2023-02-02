package thursday.week12.jinu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 14889번 스타트와 링크(https://www.acmicpc.net/problem/14889)
public class Question14889 {
    public static int n;
    public static int min = 101;
    public static int[][] arr;
    // StringTokenzier 클래스는 문자열을 지정한 구분자로 문자열을 쪼개주는 클래스, 일명 토큰
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];

        // 능력치 입력
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        linkCombi(new ArrayList<>(), 1, n / 2);

        System.out.println(min);

    }

    public static void linkCombi(ArrayList<Integer> start, int index, int count) {

        if (count == 0) {
            ArrayList<Integer> link = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                if (!start.contains(i)) {
                    link.add(i);
                }
            }

            solve(start, link);
            return;
        }

        for (int i = index; i <= n; i++) {

            start.add(i);
            linkCombi(start, i + 1, count - 1);
            start.remove(start.size() - 1);
        }
    }

    public static void solve(ArrayList<Integer> start, ArrayList<Integer> link) {

        int startSum = 0;
        int linkSum = 0;

        for (int i = 0; i < start.size() - 1; i++) {
            for (int j = i + 1; j < start.size(); j++) {

                int x = start.get(i);
                int y = start.get(j);
                startSum += arr[x][y] + arr[y][x];
            }
        }

        for (int i = 0; i < link.size() - 1; i++) {
            for (int j = i + 1; j < link.size(); j++) {
                int x = link.get(i);
                int y = link.get(j);
                linkSum += arr[x][y] + arr[y][x];
            }
        }

        int result = Math.abs(startSum - linkSum);
        min = Math.min(min, result);

    }

}
