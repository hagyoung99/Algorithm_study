package sets_and_maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BaekJoon14425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;

        Set<String> arr = new HashSet<String>();
        String check = null;


        for (int i = 0; i < N; i++) {
            arr.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            check = br.readLine();
            if (arr.contains(check)) result++;
        }

        System.out.println(result);
    }
}
