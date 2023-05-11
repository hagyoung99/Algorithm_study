package thursday.week26.jinu;

import java.util.*;
import java.io.*;

public class BOJ3048 {
    static class Ant {
        char value;
        int direction;

        public Ant(char value, int direction) {
            this.value = value;
            this.direction = direction;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        int n1 = Integer.parseInt(stk.nextToken());
        int n2 = Integer.parseInt(stk.nextToken());
        Ant[] group1 = new Ant[n1 + 1];
        Ant[] group2 = new Ant[n2 + 1];

        String input = bfr.readLine();
        for (int i = n1 - 1; i >= 0; i--) {
            group1[i] = new Ant(input.charAt(n1 - i - 1), 1);
        }

        input = bfr.readLine();
        for (int i = 0; i < n2; i++) {
            group2[i] = new Ant(input.charAt(i), -1);
        }

        Ant[] start = new Ant[n1 + n2];
        for (int i = 0; i < n1; i++)
            start[i] = group1[i];
        for (int i = n1; i < n1 + n2; i++)
            start[i] = group2[i - n1];
        int T = Integer.parseInt(bfr.readLine());

        Ant[] end = start;
        for (int i = 0; i < T; i++) {
            // Ant[] cur = end; // 얕은 복사의 문제!!
            Ant[] cur = end.clone();
            for (int j = 0; j < n1 + n2 - 1; j++) {
                if (cur[j].direction == 1 && cur[j + 1].direction == -1) {
                    Ant tmp = cur[j];
                    end[j] = cur[j + 1];
                    end[j + 1] = tmp;
                } else
                    continue;
            }
        }

        /** 이렇게 하면 굳이 배열 여러 개를 선언해서 메모리를 낭비할 필요가 없다 */
        // for(int i=0; i<T; i++){
        // for(int j=0; j<n1+n2-1; j++){
        // Ant a = start[j];
        // Ant b = start[j+1];
        // if(start[j].direction == 1 && start[j+1].direction == -1){
        // start[j] = b;
        // start[j+1] = a;
        // j++;
        // }
        // else
        // continue;
        // }
        // }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n1 + n2; i++)
            sb.append(end[i].value);

        bfw.write(sb.toString());
        bfw.close();
    }
}