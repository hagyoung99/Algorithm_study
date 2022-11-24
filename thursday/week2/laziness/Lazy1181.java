import java.io.*;
import java.util.*;

public class Lazy1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0 ; i < n ; i += 1) arr[i] = br.readLine();
        arr = new HashSet<>(Arrays.asList(arr)).toArray(new String[0]); // 중복제거
        
        Arrays.sort(arr, (a, b) -> {
            if(a.length() == b.length()) return a.compareTo(b); // 두 번째 사전 순
            else return a.length() - b.length(); // 첫 번쨰 길이 순
        });
        for(String s : arr) System.out.println(s);
    }
}
