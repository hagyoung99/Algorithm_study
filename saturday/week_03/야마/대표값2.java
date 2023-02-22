import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[5]; //입력할 값을 담을 배열
        for (int i = 0; i < 5; i++) num[i] = sc.nextInt();
        Arrays.sort(num); 
        System.out.println(Arrays.stream(num).sum()/5); // 입력받은 수의 총합구하기 5로나눔
        System.out.print(num[2]);
    }
}
