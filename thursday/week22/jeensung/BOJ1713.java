package jeensung;
import java.util.*;
class Point{
	int id;
	int like;
	int time;
	boolean is;
	Point(int id, int like, int time, boolean is){
		this.id = id;
		this.like = like;
		this.time = time;
		this.is = is;
	}
}
public class BOJ1713 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int x = scan.nextInt();
		Point[] arr = new Point[101];
		List<Point> list = new ArrayList<>();
		for(int i = 0; i < x; i++) {
			int now = scan.nextInt();
			if(arr[now] == null)
				arr[now] = new Point(now, 0, 0, false);
			if(arr[now].is)
				arr[now].like++;
			else {
				if(list.size() == n) {
					Collections.sort(list, new Comparator<Point>(){
						@Override
						public int compare(Point o1, Point o2) {
							// TODO Auto-generated method stub
							if(o1.like == o2.like)
								return o1.time - o2.time;
							return o1.like - o2.like;
						}
						
					});
					list.get(0).is = false;
					list.remove(0);
				}
				arr[now].like = 1;
				arr[now].time = i;
				arr[now].is = true;
				list.add(arr[now]);
			}
		}
		Collections.sort(list, (o1, o2) -> o1.id - o2.id);
		for(Point now : list)
			System.out.print(now.id+ " ");
		
	}

}
