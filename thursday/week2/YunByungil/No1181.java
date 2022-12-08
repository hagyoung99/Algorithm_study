package study.thursday.week1.YunByungil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> test = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            test.add(br.readLine());
        }

        Collections.sort(test, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else if (o1.length() != o2.length()){
                    return o1.length() - o2.length();
                } else {
                    return 0;
                }
            }
        });
        Set<String> result = new LinkedHashSet<>(test);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
