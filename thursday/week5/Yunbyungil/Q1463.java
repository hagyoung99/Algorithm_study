
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1463{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String str = "" + i;
            if (str.contains("666")) {
                list.add(i);
            }
            if(list.size() == 10000) {
                break;
            }
        }

        System.out.println(list.get(n - 1));
    }
}
