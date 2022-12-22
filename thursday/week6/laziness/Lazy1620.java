import java.io.*;
import java.util.*;

public class Lazy1620 {
    public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuffer stringBuffer = new StringBuffer();
    public static void main(String[] args) throws IOException {
        String[] tmp = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]), m = Integer.parseInt(tmp[1]);

        HashMap<Integer, String> pocketMap1 = new HashMap<>();
        HashMap<String, Integer> pocketMap2 = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            String pocketMon = bufferedReader.readLine();
            pocketMap1.put(i, pocketMon);
            pocketMap2.put(pocketMon, i);
        }

        for (int i = 0; i < m; i++) {
            String quest = bufferedReader.readLine();
            if(isNumber(quest)) stringBuffer.append(pocketMap1.get(Integer.parseInt(quest))).append("\n");
            else stringBuffer.append(pocketMap2.get(quest)).append("\n");
        }
        System.out.print(stringBuffer);
    }

    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
