package thursday.week15.jinu;

import java.io.*;
import java.util.*;

// 16928번 뱀과 사다리 게임(https://www.acmicpc.net/problem/16928)
public class Qusetion16928 {

    // 게임판 상황 파악
    public static int[] map = new int[101];
    // 방문 체크
    public static boolean[] visited = new boolean[101];
    // 사다리 개수, 뱀 개수
    public static int ladderNum, snakeNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        ladderNum = Integer.parseInt(st.nextToken());
        snakeNum = Integer.parseInt(st.nextToken());

        for (int x = 0; x < ladderNum + snakeNum; x++) {
            st = new StringTokenizer(br.readLine());

            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());

        }

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        visited[1] = true;

        int answer = 0;
        boolean find = false;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int x = 0; x < size; x++) {
                int now = queue.poll();

                // 100 도착
                if (now == 100) {
                    find = true;
                    break;
                }

                for (int y = 1; y <= 6; y++) {
                    // 100번 칸을 넘어가면 이동할 수 없음 -> 100번 칸 이하로 이동 가능
                    if (now + y <= 100) {

                        int next = now + y;

                        // 사다리나 뱀이 있는 경우 타고 이동
                        if (map[next] > 0) {
                            next = map[next];
                        }

                        // 이전에 방문하지 않았던 경우만 이동
                        if (!visited[next]) {
                            visited[next] = true;
                            queue.add(next);
                        }
                    }
                }
            }
            if (find)
                break;

            answer++;
        }

        bw.write(String.valueOf(answer));

        bw.flush();

    }

}
