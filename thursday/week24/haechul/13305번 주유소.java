package BOJ.boj13305;

import java.util.*;

public class Main {
  public static void Main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt(); // 주유소 갯수
        long[] road = new long[n - 1];
        long[] station = new long[n];

        for (int i = 0; i < n - 1; i++) {
            road[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            station[i] = sc.nextInt();
        }

        long sum = 0;
        long min = station[0];

        for (int i = 0; i < n - 1; i++) {
            if (station[i] < min) {
                min = station[i];
            }
            sum += min * road[i];
        }

        System.out.println(sum);
    
    
  }
}
