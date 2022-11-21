import java.util.*;
import java.lang.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); 
        
        int a = sc.nextInt();           //세수 입력받음
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        int[] numbers = {a, b, c};      
        
        Arrays.sort(numbers);           //배열정렬
        
        System.out.println(numbers[1]); //두번째로 큰수
    } 
}
