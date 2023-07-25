package BOJ.boj1092;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[] crane = new Integer[n];
        for (int i = 0; i < n; i++) {
            crane[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        Integer[] boxes = new Integer[m];
        for (int i = 0; i < m; i++) {
            boxes[i] = sc.nextInt();
        }

        Arrays.sort(crane, Collections.reverseOrder());
        Arrays.sort(boxes, Collections.reverseOrder());

        if (boxes[0] > crane[0]) {
            System.out.println(-1);
            System.exit(0);
        }

        int cnt = 0;
        int[] start = new int[n];
        while (m > 0) {
            for (int i = 0; i < n; i++) {
                if (m < 1) break;
                for (int j = start[i]; j < boxes.length; j++) {
                    if (boxes[j] == 0 || boxes[j] > crane[i]) {
                        start[i]++;
                        continue;
                    }
                    boxes[j] = 0;
                    m--;
                    break;
                }
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
