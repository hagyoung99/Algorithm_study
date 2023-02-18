import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int []arr = new int[N];
        int max = 0;
        int cnt = 1;

        ArrayList<Integer> daySum = new ArrayList<>(N-X);

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i< N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i < N-X ; i++){
            int sum = 0;
            for(int j = i ; j < i+X ; j++){
                sum += arr[j];
            }
            daySum.add(sum);
        }
        for(int i = 0 ; i < daySum.size() ; i++){
            if(daySum.get(i) == max) cnt+=1;
            if(daySum.get(i) > max) max = daySum.get(i);
        }
        System.out.println(max);
        System.out.println(cnt);
    }
}
