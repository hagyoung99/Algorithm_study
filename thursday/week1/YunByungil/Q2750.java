package 정렬.bronze.no2750;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int[] number = new int[count];
        int temp = 0;
        for (int i = 0; i < count; i++) {
            number[i] = scanner.nextInt();
        }

        for (int i = 0; i < count - 1; i++) {
            for (int j = i; j < count; j++) {
                if (number[i] > number[j]) {
                    temp = number[i];
                    number[i] = number[j];
                    number[j] = temp;
                }
            }
        }

        for (int i : number) {
            System.out.println(i);
        }
    }
}
