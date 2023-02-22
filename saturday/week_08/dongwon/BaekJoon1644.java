package Two_point;

import java.util.ArrayList;
import java.util.Scanner;

public class BaekJoon1644 {

    static ArrayList<Integer> prime = new ArrayList<>();


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        boolean arr[] = new boolean[N + 1];
        arr[0] = true;
        arr[1] = true;

        for (int i = 2; i <= N; i++) {
            if (arr[i] == false) {
                for (int j = 1; j * i <= N; j++) arr[i * j] = true;
                prime.add(i);
                }
            }
        int count = primearr(N);
        System.out.println(count);
    }
    public static int primearr(int N) {
        int start = 0;
        int size = prime.size();
        int end = 0;
        int sum = 2;
        int count = 0;

        while (start < size && end < size) {
            if (sum == N) {
                count++;
                sum -= prime.get(start);
                start++;
            } else if (sum < N) {
                end++;
                sum += prime.get(end);
                if (end == size)
                    break;
            } else {
                sum -= prime.get(start);
                start++;
            }
        }
        return count;
    }
}
