import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

// 중복과 관련된 문제는 Set을 먼저 고려하는 게 좋다고 생각합니다.
// <Contains() 시간복잡도 >
// ArrayList, Array : O(N)
// HashSet : O(1) - map

public class BJ_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < N ; i++){
            set.add(br.readLine());
        }

        ArrayList<String> result = new ArrayList<>();
        for(int i = 0 ; i < M ; i++){
            String tmp = br.readLine();
            if(set.contains(tmp)) result.add(tmp);
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(int i = 0 ; i <result.size() ; i++){
            System.out.println(result.get(i));
        }

    }
}
