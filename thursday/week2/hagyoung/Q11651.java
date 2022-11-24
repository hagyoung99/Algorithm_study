package thursday.week2.hagyoung;

import java.util.*;
import java.io.*;
public class Q11651 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        List<Point> answer = new ArrayList<>();
        for(int i=0;i<n;i++){
            String[] xy = in.readLine().split(" ");
            answer.add(new Point(Integer.parseInt(xy[1]), Integer.parseInt(xy[0])));
        }
        Collections.sort(answer);
        for(Point x : answer) System.out.println(x.y +" "+x.x);
    }
}

class Point  implements Comparable<Point>{
    public int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o){
        if(this.y==o.y) {
            if(this.x==o.x) return 0;
            else if(this.x<o.x) return -1;
            else return 1;
        }
        else if(this.y<o.y) return -1;
        else return 1;

        
    }
}
