package thursday.week11.laziness;

import java.util.ArrayList;
import java.util.Scanner;

public class Lazy15649 {
    public static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        makePermutation(n, m, new ArrayList<>());
        scanner.close();
    }
    
    private static void makePermutation(int n, int r, ArrayList<Integer> list) {
        if(list.size() == r) {
            for (int i : list) System.out.print(i + " ");
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!list.contains(i)) {
                list.add(i);
                makePermutation(n, r, list);
                list.remove(Integer.valueOf(i));
            }
        }
    }
}