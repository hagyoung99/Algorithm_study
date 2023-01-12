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

        n = Integer.parseInt(st.nextToken()); // n개의 물건
        c = Integer.parseInt(st.nextToken()); // c만큼 담을 수 있는 가방 ( 무게 )

        arr = new int[n]; // n개의 물건을 담는 배열
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 반으로 나누어서, 담을 수 있는 모든 경우의 수를 센다.
            /*
            예를 들면, 1 2 3 4가 있으면 (1, 2) (3, 4)로 나누고
            (0), (1), (2), (3) 이런식으로 담는다. ( 새로운 배열에 ) => 재귀를 이용하자
             */

        a = new ArrayList<>(); // 담을 수 있는 모든 경우의 수 (half)
        b = new ArrayList<>();

        dfsA(0, 0);
        dfsB(n / 2, 0);


        Collections.sort(b);

        // 경우의 수가 너무 많기 때문에 이분 탐색으로 값을 확인한다. 어떻게?
            /*
            List<Integer> a 의 값을 a.get(0, 1, 2, .... a.size)까지 넣으면서
            List<Integer> b 의 값 즉 정렬 된 배열 안에서 이분 탐색 알고리즘을 사용한다.
            a.get(0)의 값이 0이라고 가정하면 b의 절반의 값을 더했을 때 c보다 작거나 같다?
            그러면 그 인덱스 + 1을 하면 개수르 구할 수 있다.
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


    // 재귀를 이용해서 모든 합을 담는 메서드
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
