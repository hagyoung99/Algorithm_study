package samsung02;

import java.util.*;
class Words{
    int length;
    String str;
    Words(int length, String str){
        this.length = length;
        this.str = str;
    }
}
public class BOJ1181 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Words> list = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        for(int i = 0; i < n; i++) {
            String st = scan.next();
            if(!hashSet.contains(st)) {
                hashSet.add(st);
                list.add(new Words(st.length(), st));
            }
        }
        Collections.sort(list, new Comparator<Words>() {
            @Override
            public int compare(Words o1, Words o2) {
                if(o1.length == o2.length)
                    return o1.str.compareTo(o2.str);
                return o1.length - o2.length;
            }
        });
        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i).str);
    }
}
