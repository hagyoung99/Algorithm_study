package samsung01.jeensung;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;
class BOJ10816{
    static int[] ans;
    static int n, m;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int x = scan.nextInt();
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }
        m = scan.nextInt();
        ans = new int[m];
        for(int i = 0; i < m; i++)
            ans[i] = scan.nextInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < m; i++){
            bw.write(hashMap.getOrDefault(ans[i], 0) + " ");
        }
        bw.flush();
        bw.close();
    }
}