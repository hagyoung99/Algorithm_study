import java.awt.Point;
import java.util.*;
public class Main {
	static ArrayList<Point> list;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		list = new ArrayList<>();
		for(int i = 0; i < 4; i++) 
			list.add(new Point(scan.nextInt(), scan.nextInt()));
		int x = ccw(list.get(0), list.get(1), list.get(2)) * ccw(list.get(0), list.get(1), list.get(3));
		int y = ccw(list.get(2), list.get(3), list.get(0)) * ccw(list.get(2), list.get(3), list.get(1));
		if(x < 0 && y < 0)
			System.out.println(1);
		else
			System.out.println(0);
	}
	static int ccw(Point a, Point b, Point c) {
		int sum = a.x * b.y + b.x * c.y + c.x * a.y - (a.y * b.x + b.y * c.x + c.y * a.x);
		if(sum > 0)
			return 1;
		else if(sum == 0)
			return 0;
		else
			return -1;
	}
}
