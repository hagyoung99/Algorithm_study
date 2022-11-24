import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q1181 {

    // 문자열 비교 함수
    public static int stringCompare(String x, String y) {
        int i = 0;
        while (x.charAt(i) == y.charAt(i)) {
            i++;
        }
        return x.charAt(i) - y.charAt(i);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<String>();

        // 입력
        for (int i = 0; i < num; i++) {
            set.add(br.readLine());
        }

        String[] arr = set.toArray(new String[set.size()]);

        // 정렬
        Arrays.sort(arr, (x, y) -> {
            if (x.length() == y.length()) {
                return stringCompare(x, y);
            }
            return x.length() - y.length();
        });

        // 출력
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
