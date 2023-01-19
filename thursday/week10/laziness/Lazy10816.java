package thursday.week10.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lazy10816 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int[] arr = new int[20_000_001];
        for(int i = 0 ; i < n ; i++) arr[Integer.parseInt(st.nextToken()) + 10_000_000]++;
        
        int m = Integer.parseInt(reader.readLine());
        st = new StringTokenizer(reader.readLine());

        for(int i = 0 ; i < m ; i++) {
            sb.append(arr[Integer.parseInt(st.nextToken()) + 10_000_000]);
            if(i != m - 1) sb.append(" ");
        }
        System.out.println(sb.toString());
        reader.close();
    }
}
