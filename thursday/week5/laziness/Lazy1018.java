import java.io.*;

public class Lazy1018 {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] length = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(length[0]);
        int m = Integer.parseInt(length[1]);
        String[][] arr = new String[n][m];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = bufferedReader.readLine().split("");
        } // 입력 끝
        int candidate1 = getCandidate(n, m, arr, "W", "B"); // 첫번째 정답 배열에 대한 후보군 중 가장 작은 수
        int candidate2 = getCandidate(n, m, arr, "B", "W"); // 주번째 정답 배열에 대한 후보군 중 가장 작은 수
        System.out.println(Math.min(candidate1, candidate2));
    }

    private static int getCandidate(int n, int m, String[][] arr, String start, String next) {
        String[][] answer = new String[n][m];
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i % 2 == j % 2) answer[i][j] = start;
                else answer[i][j] = next;
            }
        } // 일단 정답 배열을 n x m으로 채운 후
        for(int i = 0; i < n - 7; i++) {
            for(int j = 0; j < m - 7; j++) {
                int candidate = getMinCount(arr, answer, i, j); // 8개씩 끊어서 정답의 후보를 구하는 과정
                if(ret > candidate) ret = candidate; // 작다면 갱신
            }
        }
        return ret;
    }

    private static int getMinCount(String[][] arr, String[][] answer, int i, int j) {
        int candidate = 0;
        for (int k = i; k < i + 8; k++) {
            for (int l = j; l < j + 8; l++) {
                if(!answer[k][l].equals(arr[k][l])) candidate++;
            }
        }
        return candidate;
    }
}
