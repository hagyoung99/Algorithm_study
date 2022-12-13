package thursday.week3.hagyoung;

import java.util.*;
import java.io.*;
public class Q10814{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Point(i, Integer.parseInt(st.nextToken()),st.nextToken()));  
        }
        Collections.sort(list);
        for(Point x:list){
            System.out.println(x.age+" "+x.name);
        }

    }
}

class Point  implements Comparable<Point>{
    int age, num;
    String name;
    Point(int num, int age, String name){
        this.num = num;
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Point o){
        if(this.age==o.age) return this.num-o.num;
        else return this.age-o.age;
    }
}