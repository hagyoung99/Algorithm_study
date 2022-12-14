import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q7568 {
    public static int rank(int[][] people, int num) {
        int rank = 1;

        int[] target = people[num];

        for (int i = 0; i < people.length; i++) {
            if (i == num) {
                continue;
            }
            if (people[i][0] > target[0] && people[i][1] > target[1]) {
                rank++;
            }
        }
        return rank;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int[][] people = new int[num][2];

        for (int i = 0; i < num; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(tokenizer.nextToken());
            people[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int i = 0; i < num; i++) {
            System.out.print(rank(people, i) + " ");
        }
    }
}
