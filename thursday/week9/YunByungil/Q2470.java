import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2470 {
    public static void main(String[] args) throws IOException {
        // 1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // ?©ì•¡????n
        int[] arr = new int[n];

        // ì£¼ì–´ì§??œí•œ ?œê°„?€ 1ì´? n??ë²”ìœ„??-1,000,000,000 ?´ìƒ 1,000,000,000 ?´í•˜
        // 2ì¤?for ë¬¸ì„ ?¬ìš©?´ì„œ ?´ê²°?˜ëŠ” ë¬¸ì œê°€ ?„ë‹ˆ?? ???¬ì¸?°ë? ?Œê³ ë¦¬ì¦˜ ?œìš©

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } // ?©ì•¡???´ëŠ” ë°°ì—´
        // ìµœì¢…?ìœ¼ë¡?0ê³?ê°€??ê°€ê¹Œìš´ ê°’ì„ ì°¾ëŠ” ê²ƒì´??

        // 2. ë§??¼ìª½ ê°’ê³¼ ë§??¤ë¥¸ìª?ê°’ì„ ë¹„êµ?œë‹¤.
        // ???˜ì˜ ?©ì„ ?ˆëŒ“ê°??Œìš°ê³? ìµœì†Ÿê°’ì„ ê³„ì† ê°±ì‹ ?˜ë©´?????˜ì˜ ê°? -98, 99ì²˜ëŸ¼ )??ê³„ì† ê°±ì‹ .

        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;

        int min = Integer.MAX_VALUE;
        int number = 0; // number ê°’ìœ¼ë¡?ìµœì†Ÿê°’ì„ ì°¾ëŠ”??
        int a = 0; // ????ì¤??˜ë‚˜
        int b = 0; // ????ì¤??˜ë‚˜ ( ???˜ì˜ ?©ì´ 0?´ë‘ ê°€ê¹Œìš¸ ?? ê·???index ê°’ì´ a, b?? )
        int check = 0; // check ê°’ìœ¼ë¡?index ë²ˆí˜¸ë¥?ì¡°ì •?????ˆê²Œ?œë‹¤
        while (start < end) {
            check = arr[start] + arr[end];
            number = Math.abs(arr[start] + arr[end]);

            if (min > number) {

                min = number;
                a = arr[start];
                b = arr[end];
            }
            if (check > 0) {
                end--;
            } else if (check < 0) {
                start++;
            } else if (check == 0) {
                break;
            }
        }

        System.out.println(a + " " + b);
    }
}
