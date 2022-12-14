import java.io.*;
import java.util.*;

public class Lazy10815 {
    public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine());
        Integer[] cardInHand = Arrays.stream(bufferedReader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int m = Integer.parseInt(bufferedReader.readLine());
        Integer[] answerCards = Arrays.stream(bufferedReader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        HashSet<Integer> cardSet = new HashSet(Arrays.asList(cardInHand)); // 입력 끝 효율 높인다는 명목으로 hashSet으로 만들어줌

        int[] answerArr = new int[m];
        for(int i = 0 ; i < m ; i++) {
            if(cardSet.contains(answerCards[i])) answerArr[i] = 1;
        } // 있는지 여부를 배열에 저장
        for(int i : answerArr) System.out.print(i + " ");
    }
}
