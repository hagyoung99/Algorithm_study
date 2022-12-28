import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BJ_11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        List<String> stringList = new ArrayList<>();

        for (int i = 0 ; i < s.length() ; i++){
            for(int j = i ; j <s.length(); j++){
                stringList.add(s.substring(i,j+1));
            }
        }
        System.out.println("부분 문자열 : " +stringList);

        Set<String> setString = new HashSet<>(stringList);
        System.out.println("서로 다른 문자열 : " + setString.size());
    }
}

