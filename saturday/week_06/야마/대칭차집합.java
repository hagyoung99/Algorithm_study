import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		Set<Integer> setA = new HashSet<>();
		Set<Integer> setB = new HashSet<>();
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<A; i++)
			setA.add(Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<B; i++)
			setB.add(Integer.parseInt(st.nextToken()));
		
		Set<Integer> copy = new HashSet<>(setA);//setA복사
		
		setA.removeAll(setB);//A-B
		setB.removeAll(copy);//B-A
		setA.addAll(setB);//합

		System.out.print(setA.size());//원소 개수 출력
	
		br.close();
	}
}
