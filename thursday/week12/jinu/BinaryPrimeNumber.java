package thursday.week12.jinu;

public class BinaryPrimeNumber {

    public int solution(int n, int k) {

        int answer = 0;
        String convertNum = solve(n, k);

        int j = 0;
        for (int i = 0; i < convertNum.length() - 1; i = j) {
            // convertNum[j]가 0을 만날때까지 또는 문자열의 끝까지
            for (j = i + 1; j < convertNum.length() && convertNum.charAt(j) != '0'; j++)
                ;
            if (prime(Long.parseLong(convertNum.substring(i, j))))
                answer++;
        }
        return answer;
    }

    private static boolean prime(long num) {

        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static String solve(int n, int k) {

        StringBuilder str = new StringBuilder();

        while (n > 0) {
            str.append(n % k);
            n /= k;
        }

        str = str.reverse();
        return str.toString();
    }

}
