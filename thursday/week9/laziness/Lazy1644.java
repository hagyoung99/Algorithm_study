package thursday.week9.laziness;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lazy1644 {
    public static int n;
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int answer = 0;

        getPrime();

		for(int i = 0; i < list.size(); i++) {
			int sum = 0;
			for(int j = 0; j + i < list.size(); j++) {
				sum += list.get(i+j);
				if(sum == n) {
					answer++; break;
				} else if(sum > n) {
					break;
                }
			}
		}

        


        System.out.println(answer);
        scanner.close();
    }

    private static void getPrime() {
        boolean[] primes = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            primes[i] = true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primes[i]) {
                for (int j = i + i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if(primes[i]) list.add(i);
        }
    }
}
