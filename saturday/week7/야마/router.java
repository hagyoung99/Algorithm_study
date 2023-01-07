import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr15828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		while(true) {
			int k =Integer.parseInt(br.readLine());
			if(k==-1) break;
			if(k==0)
				queue.remove();
			if(k!=0)
				queue.add(k);
		}
		if(queue.isEmpty())
			System.out.println("empty");
		else {
			while(!queue.isEmpty())
				System.out.print(queue.poll()+" ");
		}

	}

}
