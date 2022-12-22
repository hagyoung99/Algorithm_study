import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Lazy1269 {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        String[] input = bufferedReader.readLine().split(" ");
        Integer[] arrA = Arrays.stream(bufferedReader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] arrB = Arrays.stream(bufferedReader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        HashSet<Integer> setA = new HashSet<>(Arrays.asList(arrA));
        HashSet<Integer> setB = new HashSet<>(Arrays.asList(arrB));
        int answer = setA.size() + setB.size();
        setA.retainAll(setB);
        answer -= setA.size() * 2;
        System.out.println(answer);
    }
}
