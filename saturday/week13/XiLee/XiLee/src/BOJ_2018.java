import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_2018 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int num[] = new int[n];

        for (int i=0; i<n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1, end = 1, sum = 1, answer = 1;

        while(start < n){
            if(sum == n) answer++;
            else if(sum < n){
                end++;
                sum+=end;
            }else {
                sum -= start;
                start++;
            }
        }
        System.out.println(answer);
    }
}
