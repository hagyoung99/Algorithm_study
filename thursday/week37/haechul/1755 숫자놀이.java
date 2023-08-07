package BOJ.boj1755;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] sequence = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        int N = sc.nextInt();
        int M = sc.nextInt();

        HashMap<Integer, String> map = new HashMap<>();

        for (int i = N; i <= M; i++) {
            if (i < 10) {
                map.put(i, sequence[i]);
            } else {
                int retain = i % 10;
                map.put(i, sequence[(i - retain) / 10] + " " + sequence[retain]);
            }
        }

        ArrayList<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o1).compareTo(map.get(o2)));

        for (int i = 0; i < keySet.size(); i++) {
            if (i >= 10 && i % 10 == 0) System.out.println();
            System.out.print(keySet.get(i) + " ");
        }


    }
}
