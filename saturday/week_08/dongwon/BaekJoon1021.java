package Cue_Deck;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BaekJoon1021 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        LinkedList<Integer> d = new LinkedList<>();
        int arr[] = new int[M];
        int count = 0;

        for (int i = 1; i <= N; i++) d.add(i);
        for (int i = 0; i < M; i++) arr[i] = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int target = d.indexOf(arr[i]);
            int middle;

            if (d.size() % 2 == 0) middle = d.size() / 2 - 1;
            else middle = d.size() / 2;

            if (target <= middle) {
                for (int j = 0; j < target; j++) {
                    int temp = d.pollFirst();
                    d.offerLast(temp);
                    count++;
                }
            } else {
                for (int j = 0; j < d.size() - target; j++) {
                    int temp = d.pollLast();
                    d.offerFirst(temp);
                    count++;
                }
            }
            d.pollFirst();
        }
        System.out.println(count);
    }
}
