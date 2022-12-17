import java.io.*;
import java.util.*;

public class Baekjoon_10816 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Integer,Integer> map = new HashMap<>(); // 카드 몇 장 들고 있는지 저장

        int m = Integer.parseInt(br.readLine());
        int[] U_card = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            U_card[i] = Integer.parseInt(st.nextToken());
            map.put(m,map.getOrDefault(m, 0)+1);
        }
        Arrays.sort(U_card);


        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            num = Arrays.binarySearch(U_card,num);
            if(num>=0)
                num = map.get(n);
            else
                num = 0;

            sb.append(n).append(" ");
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
        System.out.println(sb);
    }
}


