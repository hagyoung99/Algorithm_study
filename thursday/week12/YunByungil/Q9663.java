import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReMain {

    public static int[] arr;
    public static int n;
    public static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        dfs(0);
        System.out.println(count);

    }

    public static void dfs(int depth) {
        // 모든 원소를 다 채운 상태면 count 증가 및 return
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i;
            // 놓을 수 있는 위치일 경우 재귀호출
            if (check(depth)) {
                dfs(depth + 1);
            }
        }

    }

    public static boolean check(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) {
                return false;
            }

            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}
