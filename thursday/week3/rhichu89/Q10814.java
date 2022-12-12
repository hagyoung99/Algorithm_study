import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());

        String[] arrS = new String[num];

        for (int i = 0; i < num; i++) {
            arrS[i] = br.readLine();
        }

        Arrays.sort(arrS, (x, y) -> {
            return Integer.valueOf(x.split(" ")[0]) -  Integer.valueOf(y.split(" ")[0]) ;
        });

        for (int i = 0; i < arrS.length; i++) {
            System.out.println(arrS[i]);
        }

    }
}
