package week26;
import java.util.*;
class Rank{
	int x;
	String y;
	Rank(int x, String y){
		this.x = x;
		this.y = y;
	}
}
public class BOJ20006 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int p = scan.nextInt();
		int m = scan.nextInt();
		List<Rank> list = new ArrayList<>();
		for(int i = 0; i < p; i++) {
			int x = scan.nextInt();
			String y = scan.next();
			list.add(new Rank(x, y));
		}
		Collections.sort(list, new Comparator<Rank>() {
			@Override
			public int compare(Rank o1, Rank o2) {
				return o1.x - o2.x;
			}
		});
		List<Rank>[] aList = new List[p];
		for(int i = 0; i < p; i++)
			aList[i] = new ArrayList<>();
		int index = 0;
		for(int i = 0; i < p; i++) {
			if(aList[index].size() < m) {
				int now = list.get(i).x;
				if(now - 10 <= list.get(i).x && now + 10 >= list.get(i).x) 
					aList[index].add(new Rank(list.get(i).x, list.get(i).y));
				else 
					index++;
			}else {
				index++;
				aList[index].add(new Rank(list.get(i).x, list.get(i).y));
			}
		}
		for(int i = 0; i < p; i++)
			Collections.sort(aList[i], new Comparator<Rank>() {

				@Override
				public int compare(Rank o1, Rank o2) {
					return o1.y.compareTo(o2.y);
				}
			});
		for(int i = 0; i < p; i++) {
			if(aList[i].size() > 0) {
				if(aList[i].size() < m) {
					System.out.println("Waiting!");
					for(int j = 0; j < aList[i].size(); j++)
						System.out.println(aList[i].get(j).x + " " + aList[i].get(j).y);
				}else {
					System.out.println("Started!");
					for(int j = 0; j < aList[i].size(); j++)
						System.out.println(aList[i].get(j).x + " " + aList[i].get(j).y);
				}
			}else
				break;
		}
	}

}
