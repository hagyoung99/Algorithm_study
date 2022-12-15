import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Q10815 {

    public static int binarySearch(int[] cards, int cardNum, int num) {
        int left = 0;
        int right = cardNum - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            if (cards[mid] == num) {
                return 1;
            }
            if (cards[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int userCardNum = Integer.parseInt(st.nextToken());
        int[] userCards = new int[userCardNum];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < userCardNum; i++) {
            userCards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(userCards);

        int cardNum = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cardNum; i++) {
            int num = Integer.parseInt(st.nextToken());
            System.out.print(binarySearch(userCards, userCardNum, num) + " ");
        }
    }
}
