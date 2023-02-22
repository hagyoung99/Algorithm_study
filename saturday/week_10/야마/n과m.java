//문제
// 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
//
// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
// 입력
// 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
//
// 출력
// 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
//
// 수열은 사전 순으로 증가하는 순서로 출력해야 한다.

import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
        import java.util.StringTokenizer;

public class main {

    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];
        dfs(N, M, 0);
        System.out.println(sb);

    }

    public static void dfs(int N, int M, int depth) {
        if (depth == M) { //// 재귀 깊이가 M과 같아지면 탐색과정에서 담았던 배열을 출력
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        //해당 노드값을 방문하지 않았다면
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;// 사용 숫자 방문처리
                arr[depth] = i + 1; // 해당 깊이를 index로 하여 i + 1 값 저장
                dfs(N, M, depth + 1);
                visit[i] = false; // 다음 자식 노드 방문을 위해 depth 1 증가시키면서 재귀호출


                ////중복되는 수는 담을수 없기에 방문할 필요조차 없다. 즉, 방문 상태를 판단하기 위해 visit[] 배열이 있는 것이고,
                // 해당 index가 방문하지 않는 노드(값)일 때만 재귀호출을 해주면 된다.
            }
        }
    }

}
