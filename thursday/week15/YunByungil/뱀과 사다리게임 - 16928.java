package 그래프와순회.골드.뱀과사다리게임_16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static int[] arr;
    public static boolean[] visit;

    public static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 사다리의 갯수 n
        m = Integer.parseInt(st.nextToken()); // 뱀의 갯수 m

        arr = new int[101];
        visit = new boolean[101];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[start] = -end;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[start] = -end;
        }

        bfs();

        System.out.println(arr[100]);

    }

    public static void bfs() {
        q.offer(1);
        visit[1] = true;
        while (!q.isEmpty()) {
            int nowLocation = q.poll();
            int newLocation = 0;
            int teleport = 0;

            for (int i = 1; i <= 6; i++) {
                newLocation = nowLocation + i; // 현재 위치 now에서 주사위 굴려서 new로 갈 수 있음
                if (newLocation == 100) {
                    arr[newLocation] = arr[nowLocation] + 1;
                    return;
                }


                if (!visit[newLocation] && arr[newLocation] < 0) { // 새로운 위치의 값이 음수일 때, 사다리 or 뱀
                    teleport = arr[newLocation]; // 새로운 위치의 값을 불러와서 (절댓값)
                    teleport = Math.abs(teleport);
                    if (!visit[teleport]) {
                        arr[newLocation] = arr[nowLocation] + 1;
                        arr[teleport] = arr[nowLocation] + 1;
                        visit[teleport] = true;
                        q.offer(teleport);
                    }
                }

                if (!visit[newLocation] && arr[newLocation] == 0) { // 새로운 위치가 0일 때,
                    visit[newLocation] = true;
                    arr[newLocation] = arr[nowLocation] + 1; // 현재 위치에서 1더해주면 됨
                    q.offer(newLocation);
                }
            }
        }
    }
}
