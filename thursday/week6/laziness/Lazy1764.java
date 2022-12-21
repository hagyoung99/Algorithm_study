import java.util.*;

public class Lazy1764 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt(); scanner.nextLine();
        HashSet<String> neverHeard = new HashSet<>();
        HashSet<String> neverSeen = new HashSet<>();
        for(int i = 0 ; i < n ; i++) neverHeard.add(scanner.nextLine());
        for(int i = 0 ; i < m ; i++) neverSeen.add(scanner.nextLine());
        neverSeen.retainAll(neverHeard);
        List<String> answer = new ArrayList<>(neverSeen);
        Collections.sort(answer);
        System.out.println(answer.size());
        for(String s : answer) System.out.println(s);

    }
}
