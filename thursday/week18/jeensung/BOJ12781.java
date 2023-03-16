package jeensung;
import java.util.*;
public class BOJ12781 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < 8; i++)
			list.add(scan.nextInt());
		if(list.get(0) < list.get(4) && list.get(4) < list.get(2)) {
			if(list.get(5) > Math.min(list.get(1), list.get(3)) &&
					list.get(7) < Math.min(list.get(1), list.get(3))) {
				System.out.println(1);
				System.exit(0);;
			}
			else if(list.get(7) > Math.min(list.get(1), list.get(3)) &&
					list.get(5) < Math.min(list.get(1), list.get(3))) {
				System.out.println(1);
				System.exit(0);
			}
		}else if(list.get(2) < list.get(4) && list.get(4) < list.get(0)) {
			if(list.get(5) > Math.min(list.get(1), list.get(3)) &&
					list.get(7) < Math.min(list.get(1), list.get(3))) {
				System.out.println(1); 
				System.exit(0);
			}
			else if(list.get(7) > Math.min(list.get(1), list.get(3)) &&
					list.get(5) < Math.min(list.get(1), list.get(3))) {
				System.out.println(1);
				System.exit(0);
			}
		}
		System.out.print(0);
	}

}
