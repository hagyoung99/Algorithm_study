package BOJ.boj17281;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static int N;
    static int[][] inning;
    static int max = 0;
    static int[] arr = new int[8];
    static boolean[] visit = new boolean[9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 이닝 수
        inning = new int[N][9]; // x번 이닝에서 y번 선수가 내는 결과

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 9; j++) {
                inning[i][j] = sc.nextInt();
            }
        }

        permutation(0);
        System.out.println(max);
    }

    private static void permutation(int idx) { // 8명의 선수들의 순열을 모두 구해봄
        if (idx == 8) {
            max = Math.max(play(), max);
        }

        for (int i = 1; i < 9; i++) {
            if (visit[i]) continue;
            arr[idx] = i;
            visit[i] = true;
            permutation(idx + 1);
            visit[i] = false;
        }
    }

    private static int play() {
        int nowNum = 0; // 현재 칠 타자의 타순
        int score = 0; // 점수
        int out = 0; // 아웃 개수
        int map[] = new int[3];
        int hit = 0; // 타자의 결과
        for (int i = 0; i < N; i++) {
            while (true) {
                if (nowNum < 3) {
                    hit = inning[i][arr[nowNum]];
                }
                if (nowNum == 3) {
                    hit = inning[i][0]; // 1번 선수는 4번 타자로 고정
                }
                if (nowNum > 3) {
                    hit = inning[i][arr[nowNum - 1]];
                }
                nowNum = (nowNum + 1) % 9;
                if (hit == 0) {
                    out++;
                    if (out == 3) {
                        out = 0;
                        Arrays.fill(map, 0); // 3아웃이면 이닝 종료
                        break;
                    }
                    continue;
                }
                for (int j = 2; j >= 0; j--) { // 기존 주루에 있던 선수들 위치 바꿔줌
                    int pos = j;
                    if (map[pos] == 1) {
                        map[pos] = 0;
                        pos += hit;
                        if (pos > 2) {
                            score++;
                            continue;
                        }
                        map[pos] = 1;
                    }
                }
                if (hit == 4) {
                    score++;
                    continue;
                }
                map[hit - 1] = 1;
            }
        }

        return score;
    }


}
