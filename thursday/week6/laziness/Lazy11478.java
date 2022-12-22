import java.util.*;
import java.io.*;

public class Lazy11478 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        HashSet<String> set = new HashSet<>();
        for(int i = 0 ; i < str.length() ; i++) {
            for(int j = i ; j < str.length() ; j++) {
                set.add(str.substring(i, j + 1));
            }
        }
        System.out.println(set.size());
    }
}