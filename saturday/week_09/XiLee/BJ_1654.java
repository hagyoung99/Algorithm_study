import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] LAN_ports = new int[K];
        for (int i = 0; i < K; i++) lines[i] = Integer.parseInt(in.readLine());

        Arrays.sort(LAN_ports);

        long right = LAN_ports[K-1];
        long left = 1;
        long count, half;

        // left는 최소 랜선 길이, right는 최대 랜선 길이
        // left<=right 조건에 맞게 반복하면서 이분탐색한다.
        // half는 left와 right의 중간 길이

        while(left<=right) {
            count = 0;
            half=(left+right)/2;

            for(int i=0;i<K;i++) {
                count += LAN_ports[i]/half;}

            if(count<N) right = half-1;
            else left = half+1;
        }
        System.out.println(right);
    }
}
