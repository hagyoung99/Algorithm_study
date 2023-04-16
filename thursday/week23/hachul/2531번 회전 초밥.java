package BOJ.boj2531;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        broot_force();
        sliding_window();
    }

    private static void broot_force() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 접시 수
        int d = sc.nextInt(); // 초밥의 가짓수
        int k = sc.nextInt(); // 연속해서 먹는 접시의 수
        int c = sc.nextInt(); // 쿠폰 번호
        int max = 0;
        int[] table = new int[n];

        for (int i = 0; i < n; i++) {
            table[i] = sc.nextInt();
        }

        HashSet<Integer> set = new HashSet<>();
        set.add(c);
        for (int i = 0; i < n; i++) {
            for (int j = i; j < i + k; j++) {
                set.add(table[j % n]);
            }
            max = Math.max(max, set.size());
            set.clear();
            set.add(c);
        }

        System.out.println(max);
    }
    private static void sliding_window() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 접시 수
        int d = sc.nextInt(); // 초밥의 가짓수
        int k = sc.nextInt(); // 연속해서 먹는 접시의 수
        int c = sc.nextInt(); // 쿠폰 번호

        int[] table = new int[n];
        int[] eated = new int[d + 1];

        for (int i = 0; i < n; i++) {
            table[i] = sc.nextInt();
        }

        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (eated[table[i]] == 0) {
                cnt++;
            }
            eated[table[i]]++;
        }

        int maxLen = cnt;
        for (int i = 1; i < n; i++) {
            if (maxLen <= cnt) {
                if (eated[c] == 0) {
                    maxLen = cnt + 1;
                } else {
                    maxLen = cnt;
                }
            }

            int end = (i + k - 1) % n;
            if (eated[table[end]] == 0) {
                cnt++;
            }
            eated[table[end]]++;

            eated[table[i - 1]]--;
            if (eated[table[i - 1]] == 0) {
                cnt--;
            }
        }

        System.out.println(maxLen);
    }
}
