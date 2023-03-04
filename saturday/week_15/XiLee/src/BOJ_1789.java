import java.util.Scanner;

public class BOJ_1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        int N = 0;
        int sum = 0;

        for(int i = 0 ; i < S ; i++){
            if(sum > S) break;
            sum += ++i;
            N++;
        }
        System.out.println(N);
    }
}


