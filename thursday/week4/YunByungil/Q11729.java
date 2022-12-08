package ?¬ê?.silver.no11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11729 {
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = (int) (Math.pow(2, n)) - 1;
        System.out.println(count);
        hanoi(n, 1, 2, 3);

    }

    public static void hanoi(int n, int start, int mid, int to) {
        // ì¢…ë£Œ ì¡°ê±´
        if (n == 1) {
            System.out.println(start + " " + to);
            return;
        }

        // ?˜í–‰ ì¡°ê±´
        // n - 1ê°œì˜ ?íŒ??a -> bë¡??´ë™????ê²½ìš°????
        hanoi(n - 1, start, to, mid);

        // ë§ˆì?ë§?a???¨ì? ?íŒ??cë¡??´ë™????ê²½ìš°????
        System.out.println(start + " " + to);

        // n - 1ê°œì˜ ?íŒ??b -> cë¡??´ë™????ê²½ìš°????
        hanoi(n - 1, mid, start, to);
    }
}
