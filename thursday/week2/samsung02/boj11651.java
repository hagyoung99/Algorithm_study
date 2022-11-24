package samsung02;

import java.util.Arrays;
import java.util.Scanner;
public class boj11651{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] arr = new int[n][2];
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < 2; j++) {
        		arr[i][j] = scan.nextInt();
        	}
        }
        Arrays.sort(arr, (e1,e2) ->{
        	if(e1[1] == e2[1]) {
        		return e1[0] - e2[0];
        	}else {
        		return e1[1] - e2[1];
        	}
        });
        for(int i = 0; i < n; i++) {
        	System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}

/*
다른 풀이
*/
package samsung02;
import java.util.*;
class N{
	int x;
	int y;
	N(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class boj11651{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<N> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
        	int a = scan.nextInt();
        	int b = scan.nextInt();
        	list.add(new N(a, b));
        }
        Collections.sort(list, new Comparator<N>() {
			@Override
			public int compare(N o1, N o2) {
				if(o1.y == o2.y)
					return o1.x - o2.x;
				return o1.y - o2.y;
			}
		});
        for(int i = 0; i < n; i++) {
        	System.out.println(list.get(i).x + " " + list.get(i).y);
        }
    }
}
