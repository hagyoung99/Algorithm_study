package b전체문제.실버.카드합체놀이_15903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static int x, y;

    public static Long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }



//        while (true) {
//            Arrays.sort(arr);
//            Long newValue = arr[0]+ arr[1];
//            arr[0] = newValue;
//            arr[1] = newValue;
//            m--;
//            if (m == 0) {
//                break;
//            }
//        }
        for (int i = 0; i < m; i++) {
            Arrays.sort(arr);
            Long newValue = arr[0] + arr[1];
            arr[0] = newValue;
            arr[1] = newValue;
        }

        Long result = 0L;
        for (Long i : arr) {
            result += i;
        }

        System.out.println(result);
    }
}
