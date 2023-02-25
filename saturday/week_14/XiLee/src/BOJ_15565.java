
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> lions = new ArrayList<>();

        int[] dolls = new int[N];
        for (int i=0; i < N; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());

            if (dolls[i] == 1) {
                lions.add(i);
            }
        }

        if (lions.size() < K) {
            System.out.println(-1);
            return;
        }

        int answer = Integer.MAX_VALUE;

        for (int start = 0; start < lions.size(); start++) {
            int end = start;
            int cnt = 0;

            while (end <lions.size() && cnt < K) {
                cnt++;
                end++;
            }

            if (cnt == K) {
                int left = lions.get(start);
                int right = lions.get(end-1);
                answer = Math.min(answer, right-left+1);
            }
        }
        System.out.println(answer);
    }
}

//end가 lions 범위보다 작고, cnt가 K보다 작다면 조건에 미성립되므로 cnt/ end 1씩 증가
//cnt와 k가 같아지면 start와 end의 인덱스 번호를 빼서 답을 구하기