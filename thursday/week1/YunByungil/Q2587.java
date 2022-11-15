package 정렬.bronze.no2587;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] number = new int[5];
        int avg = 0;
        int mid = 0;
        int temp = 0;
        for (int i = 0; i < number.length; i++) {
            number[i] = scanner.nextInt();
        }

        for (int i : number) {
            avg += i;
        }
        avg /= 5;

        for (int i = 0; i < number.length - 1; i++) {
            for (int j = i + 1; j < number.length;j ++) {
                if (number[i] > number[j]) {
                    temp = number[i];
                    number[i] = number[j];
                    number[j] = temp;
                }
            }
        }
        mid = number[2];

        System.out.println(avg);
        System.out.println(mid);
    }
}
