import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		in.close();
    
		int sum = factorial(N);
		System.out.println(sum);
		}
		public static int factorial(int N) {
		if(N <= 1) return 1;	//1,0  return 1 , 그 외의 경우는 N * factorial(N - 1);
		return N * factorial(N - 1);		
	}
 }
