package jeensung;

import java.util.*;
public class BOJ1436{
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        int n = scan.nextInt();
        int num = 666;
        int count = 1;
        while(count!=n){
            num++;
            if(String.valueOf(num).contains("666"))
                count++;
        }
        System.out.println(num);
    }
}