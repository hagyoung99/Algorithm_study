package BOJ.boj1457;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.nextLine();

        int[] card = new int[10];

        for (int i = 0; i < n.length(); i++) {
            int idx = n.charAt(i) - '0';
            if (idx == 9) {
                card[6]++;
            } else {
                card[idx]++;
            }
        }

        card[6] = card[6] / 2 + card[6] % 2;

        Arrays.sort(card);

        System.out.println(card[card.length - 1]);
    }
}
