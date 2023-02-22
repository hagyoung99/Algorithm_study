import java.io.*;
import java.util.*;

public class Baekjoon_10815_binary {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        int[] U_card = new int[m];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            U_card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(U_card);

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (Arrays.binarySearch(U_card, num) < 0) {
                sb.append("0 ");
            }
            else {
                sb.append("1 ");
            }
 /*

   - Arrays.binarySearch(배열, 타겟 값) : 찾는 값이 있으면 인덱스 반환, 없으면 음수를 반환

   - public static boolean binarySearch(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] < n) left = mid + 1;
            else if (arr[mid] > n) right = mid - 1;
            else return true;
        }
        return false;
    }
 */

        }
        System.out.println(sb);
    }
}



