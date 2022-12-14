import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int targetNum = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<String>();
        String target = null;
        int count = 0;


        for (int i = 0; i < num; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < targetNum; i++) {
            target = br.readLine();
            if(set.contains(target) ){
                count++;
            }
        }
        System.out.println(count);
    }
}
