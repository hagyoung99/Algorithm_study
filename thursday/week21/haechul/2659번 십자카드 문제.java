package BOJ.boj2659;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = "";
        for(int i = 0; i < 4; i++)
            line += sc.next();
        int num = Integer.parseInt(line);
        int sipja = getSigyesu(num);
        int cnt = 1;

        for(int i = 1111; i < sipja; i++) {
            if(!hasZero(i) && i == getSigyesu(i))
                cnt++;
        }

        System.out.println(cnt);

    }

    public static int getSigyesu(int num) {
        int temp = num;
        for (int i = 0; i < 3; i++) {
            num = (num * 10 + num / 1000) % 10000;
            if (num < temp)
                temp = num;
        }
        return temp;
    }


    public static boolean hasZero(int num) {
        for(int i = 0; i < 4; i++) {
            if(num % 10 == 0)
                return true;
            num /= 10;
        }
        return false;
    }
}
