import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new TreeMap<>();

		for(int i=0;i<N;i++){
			String str = br.readLine();
			String ext = str.substring(str.indexOf(".")+1);
			map.put(ext, map.getOrDefault(ext, 0)+1);
		}

		for(String ext:map.keySet()){
			System.out.println(ext+" "+ map.get(ext));
		}
	}
}
