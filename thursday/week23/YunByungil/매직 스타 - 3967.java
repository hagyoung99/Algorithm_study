package b전체문제.시뮬레이션.골드.매직스타_3967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        int x;
        int y;

        public Node() {
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static char[][] arr = new char[5][9];
    public static char[] arr2 = new char[12];
    public static boolean[] visit = new boolean[12];
    public static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 12; i++) {
            arr2[i] = (char) (i + '0' + 17);
//            System.out.println((char) (i + '0' + 17));
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < 9; j++) {
                arr[i] = str.toCharArray();

                if (arr[i][j] == 'x') {
                    list.add(new Node(i, j));
                }

                if (65 <= (int)arr[i][j] && (int)arr[i][j] <= 90) { // 알파벳이 이미 존재하면 true 처리,
                    visit[arr[i][j] - '0' - 17] = true;
                }
            }
        }



        dfs(0);
    }

    public static void dfs(int depth) {
        if (depth == list.size()) {
            if (check()) {
                for(int i=0; i<5; i++) {
                    for(int j=0; j<9; j++) {
                        System.out.print(arr[i][j]+"");
                    }
                    System.out.println();
                }
                System.exit(0);
            }
            else {
                return ;
            }
        }

        for (int i = 0; i < 12; i++) {
            if (!visit[i]) {
                Node a = list.get(depth);
                char alpha = (char) (65+i);
                arr[a.x][a.y]= alpha;
                visit[i] = true;
                dfs(depth+1);
                visit[i] = false;
                arr[a.x][a.y]= '.';
            }
        }


    }

    public static boolean check() {
        int sum1 = (arr[0][4]-'A'+1) + (arr[1][3]-'A'+1)+ (arr[2][2]-'A'+1)+(arr[3][1]-'A'+1);
        int sum2 = (arr[0][4]-'A'+1)+(arr[1][5]-'A'+1)+(arr[2][6]-'A'+1)+(arr[3][7]-'A'+1);
        int sum3 = (arr[1][1]-'A'+1)+(arr[1][3]-'A'+1)+(arr[1][5]-'A'+1)+(arr[1][7]-'A'+1);
        int sum4 = (arr[3][1]-'A'+1)+(arr[3][3]-'A'+1)+(arr[3][5]-'A'+1)+(arr[3][7]-'A'+1);
        int sum5 = (arr[4][4]-'A'+1)+(arr[3][3]-'A'+1)+(arr[2][2]-'A'+1)+(arr[1][1]-'A'+1);
        int sum6 = (arr[4][4]-'A'+1)+(arr[3][5]-'A'+1)+(arr[2][6]-'A'+1)+(arr[1][7]-'A'+1);

        if(sum1==26 && sum2 ==26 && sum3==26 && sum4==26 && sum5==26 && sum6==26) {
            return true;
        }

        return false;
    }

    public static void turnOn() {
        for (int i = 0; i < 12; i++) {
            if (!visit[i]) {
                visit[i] = true;
                return;
            }
        }
    }
    public static void turnOff() {
        for (int i = 0; i < 12; i++) {
            if (!visit[i]) {
                visit[i] = true;
            }
        }

    }
}
