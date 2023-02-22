import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i=0; i<n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);      // 오름차순

        int start = 0, end = n-1, answer = 0;

        while(start < end){
            int sum = num[start] + num[end];
            if(sum == m){
                start++;
                answer++;
            } else if (sum < m) {
                start++;
            }else end--;
        }
        System.out.println(answer);
    }
}

// n개 재료의 합이 m이 되는 것이 몇개인지?
// 맨앞, 맨뒤 인덱스 조정하는 방식

// if)  arr = {1 2 3 4 5} , sum = 6인 횟수 찾기