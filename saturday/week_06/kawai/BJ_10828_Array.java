import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10828_Array {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] Stack = new int[N];
        int top = -1;
        int cnt = 0;
        int length = 0;

        int[] tmp = new int[N];

        for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();

                switch (cmd) {
                    case "push":
                        Stack[++top] = Integer.parseInt(st.nextToken());
                        cnt++;
                        break;

                    case "pop":
                        if (top != -1)
                               tmp[i-cnt] = Stack[top--];
                        else tmp[i-cnt] = -1;
                        length++;
                        break;

                    case "size":
                        tmp[i-cnt] = top+1;
                        length++;
                        break;

                    case "empty":
                        if (top == -1)  tmp[i-cnt] = 1;
                        else  tmp[i-cnt] = 0;
                        length++;
                        break;

                    case "top":
                        if (top == -1) tmp[i-cnt] = -1;
                        else tmp[i-cnt] = Stack[top];
                        length++;
                        break;
                }
            }
        for(int j = 0 ; j < length; j++){
            System.out.println(tmp[j]);
        }
    }
}



