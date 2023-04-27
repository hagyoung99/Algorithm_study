package b전체문제.실버.주유소_13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n; // 도시의 개수
    public static long[] distance; // 도로의 길이 왼쪽 -> 오른쪽
    public static long[] price; // 왼쪽 -> 오른쪽 주유소 L당 가격

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        distance = new long[n - 1];
        price = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < price.length; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        long minCost = price[0]; // 이전까지 주유소 비용

        for (int i = 0; i < n - 1; i++) {

            /*
            이전 주유소 비용보다
            "현재 주유소 비용이 더 싸면"
            minCost, 주유소 비용을 갱신한다.
             */
            if (price[i] < minCost) {
                minCost = price[i];
            }

            sum += (minCost * distance[i]);
        }

        System.out.println(sum);

    }
}
