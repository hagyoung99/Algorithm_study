import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // a(i) + a(j) = xë¥?ë§Œì¡±?˜ëŠ” (a(i), a(j))?ì˜ ê°œìˆ˜ë¥?êµ¬í•˜??ë¬¸ì œ.
        // ë²”ìœ„ê°€ ë§¤ìš° ?¬ê¸° ?Œë¬¸??forë¬¸ì„ ?´ìš©?´ì„œ ?„ì „ ?ìƒ‰???˜ë©´ ?œê°„ ì´ˆê³¼
        // ?°ë¼?????¬ì¸???Œê³ ë¦¬ì¦˜???´ìš©?´ì„œ ?´ê²°?˜ì. ???¬ì¸?°ì˜ ?œê°„ ë³µì¡?„ëŠ” O(N)?´ë‹¤.

        // 1. input
        int n = Integer.parseInt(br.readLine()); // ?˜ì—´???¬ê¸° n

        int[] arr = new int [n]; // nê°œì˜ ?«ìë¥??´ëŠ” ë°°ì—´

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()); // ?ì—°??x

        int result = 0; // ê²°ê³¼

        int start = 0;
        int end = n - 1;
        while (start < end) {
            if (arr[start] + arr[end] == x) {
                result++;
                end--;
            } else if (arr[start] + arr[end] > x) {
                end--;
            } else if (arr[start] + arr[end] < x) {
                start++;
            }
        }

        System.out.println(result);
    }
}
