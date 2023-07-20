package thursday.week35.jinu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ19640 {

    static class Employee {
        // D = 근무일수
        // H = 화장실 급한 정도
        // L = 현재 라인
        int D, H, L;
        public boolean me;

        Employee(int D, int H, int L, boolean me) {
            this.D = D;
            this.H = H;
            this.L = L;
            this.me = me;
        }

    }

    static int N, M, K;
    static List<Employee> list[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        list = new LinkedList[M];
        for (int i = 0; i < M; i++)
            list[i] = new LinkedList<>();

        int idx = 0;
        int cnt = N;
        while (--cnt >= 0) {
            stk = new StringTokenizer(br.readLine());
            int L = idx++ % M;
            boolean check = K-- == 0;
            list[L].add(new Employee(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()), L, check));
        }

        cnt = 0;
        PriorityQueue<Employee> pq = new PriorityQueue<>(
                (o1, o2) -> o1.D == o2.D ? o1.H == o2.H ? o1.L - o2.L : o2.H - o1.H : o2.D - o1.D);

        for (int j = 0; j < M; j++)
            if (list[j].size() > 0)
                pq.add(list[j].get(0));

        for (int i = 0; i < N; i++) {
            Employee currE = pq.poll();
            if (currE.me) {
                System.out.println(cnt);
                return;
            } else {
                cnt++;
                list[currE.L].remove(0);
                if (list[currE.L].size() > 0)
                    pq.add(list[currE.L].get(0));
            }
        }
    }

}
