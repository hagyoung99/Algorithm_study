import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q1450 {
    public static int[] arr;
    public static int n, c;
    public static List<Integer> a, b;
    public static int index;

    public static void main(String[] args) throws IOException {

        // 1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // nê°œì˜ ë¬¼ê±´
        c = Integer.parseInt(st.nextToken()); // cë§Œí¼ ?´ì„ ???ˆëŠ” ê°€ë°?( ë¬´ê²Œ )

        arr = new int[n]; // nê°œì˜ ë¬¼ê±´???´ëŠ” ë°°ì—´
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2. ë°˜ìœ¼ë¡??˜ëˆ„?´ì„œ, ?´ì„ ???ˆëŠ” ëª¨ë“  ê²½ìš°???˜ë? ?¼ë‹¤.
            /*
            ?ˆë? ?¤ë©´, 1 2 3 4ê°€ ?ˆìœ¼ë©?(1, 2) (3, 4)ë¡??˜ëˆ„ê³?
            (0), (1), (2), (3) ?´ëŸ°?ìœ¼ë¡??´ëŠ”?? ( ?ˆë¡œ??ë°°ì—´??) => ?¬ê?ë¥??´ìš©?˜ì
             */

        a = new ArrayList<>(); // ?´ì„ ???ˆëŠ” ëª¨ë“  ê²½ìš°????(half)
        b = new ArrayList<>();

        dfsA(0, 0);
        dfsB(n / 2, 0);


        Collections.sort(b);

        // ê²½ìš°???˜ê? ?ˆë¬´ ë§ê¸° ?Œë¬¸???´ë¶„ ?ìƒ‰?¼ë¡œ ê°’ì„ ?•ì¸?œë‹¤. ?´ë–»ê²?
            /*
            List<Integer> a ??ê°’ì„ a.get(0, 1, 2, .... a.size)ê¹Œì? ?£ìœ¼ë©´ì„œ
            List<Integer> b ??ê°?ì¦??•ë ¬ ??ë°°ì—´ ?ˆì—???´ë¶„ ?ìƒ‰ ?Œê³ ë¦¬ì¦˜???¬ìš©?œë‹¤.
            a.get(0)??ê°’ì´ 0?´ë¼ê³?ê°€?•í•˜ë©?b???ˆë°˜??ê°’ì„ ?”í–ˆ????cë³´ë‹¤ ?‘ê±°??ê°™ë‹¤?
            ê·¸ëŸ¬ë©?ê·??¸ë±??+ 1???˜ë©´ ê°œìˆ˜ë¥?êµ¬í•  ???ˆë‹¤.
             */

        int answer = 0;
        for (int i = 0; i < a.size(); i++) {
            index = -1;
            binarySearch(0, b.size() - 1, a.get(i));
            answer += index + 1;
        }

        System.out.println(answer);
    }

    public static void binarySearch(int l, int r, int aValue) {

        while (l <= r) {
            int mid = (l + r) / 2;

            if (b.get(mid) + aValue <= c) {
                index = mid;
                l = mid + 1;
            } else if (b.get(mid) + aValue > c) {
                r = mid - 1;
            }
        }
    }


    // ?¬ê?ë¥??´ìš©?´ì„œ ëª¨ë“  ?©ì„ ?´ëŠ” ë©”ì„œ??
    public static void dfsA(int i, int sum) {
        if (sum > c) {
            return;
        }


        if (i == n / 2) {
            if (sum <= c) {
                a.add(sum);
            }
            return;
        }

        dfsA(i + 1, sum);
        dfsA(i + 1, sum + arr[i]);
    }

    public static void dfsB(int i, int sum) {
        if (sum > c) {
            return;
        }

        if (i == n) {
            if (sum <= c) {
                b.add(sum);
                return;
            }
        }

        dfsB(i + 1, sum);
        dfsB(i + 1, sum + arr[i]);
    }
}
