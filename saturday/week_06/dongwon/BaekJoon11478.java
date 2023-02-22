package sets_and_maps;

import java.util.HashSet;
import java.util.Scanner;

public class BaekJoon11478 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        HashSet<String> arr = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j <= word.length(); j++) {
                arr.add(word.substring(i, j));
            }
        }
        System.out.println(arr.size());
    }
}
