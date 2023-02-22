// 양쪽 대칭을 이룸
// (( )) 늦게 시작된 괄호가 먼저 닫혀야 함 -> Stack

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i++) {
            char[] lineStr = br.readLine().toCharArray();
            int cnt = 0;

            for(char a : lineStr) {
                if(2 <= lineStr.length && lineStr.length <= 50) {
                    if(a == '(') {
                        cnt += 1;
                    }else if(a == ')'){
                        cnt -= 1;
                    }
                }else {
                    break;
                }
            }

            if(cnt == 0)
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");

        }
        System.out.println(sb);
    }
}