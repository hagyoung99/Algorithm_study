package thursday.week24.jinu;

import java.util.*;
import java.io.*;

// 기름 통 크기 무제한
// 기본 식 5 * 2 + (3 * 2) + (4 * 1) = 20
// 최소 식(기름 값 쌀 경우 갱신) 5 * 2 + ((2 * 3) + (2 * 1)) = 18
public class BOJ13305 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dist = new int[N - 1];
        int[] cost = new int[N];

        // 거리
        for (int i = 0; i < N - 1; i++) {
            dist[i] = sc.nextInt();
        }

        // 리터당 기름값 입력
        for (int i = 0; i < N; i++) {
            cost[i] = sc.nextInt();
        }

        long sum = 0;
        long minCost = cost[0]; // 주유 최소 비용

        // 현재 주요소가 이전 주요소의 기름 값 보다 싼 경우 갱신
        for (int i = 0; i < N - 1; i++) {
            if (cost[i] < minCost) {
                minCost = cost[i];
            }
            sum += (minCost * dist[i]);
        }

        System.out.println(sum);

        sc.close();

    }

}
