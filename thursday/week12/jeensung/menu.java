package jeensung;

import java.util.*;
class Solution {
    static char[] arr;
    static boolean[] visit;
    static int temp;
    static HashMap<String, Integer> hashMap;
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        HashSet<Character> hashSet = new HashSet<>();
        for(int i = 0; i < orders.length; i++){
            for(int j = 0; j < orders[i].length(); j++){
                hashSet.add(orders[i].charAt(j));
            }
        }
        ArrayList<Character> list = new ArrayList<>(hashSet);
        Collections.sort(list);
        for(int i = 0; i < orders.length; i++){
            String z = orders[i];
            char[] p = new char[z.length()];
            for(int j = 0; j < p.length; j++)
                p[j] = z.charAt(j);
            Arrays.sort(p);
            String l = "";
            for(int j = 0; j < p.length; j++)
                l += p[j];
            orders[i] = l;
        }
        arr = new char[list.size()];
        visit = new boolean[list.size()];
        for(int i = 0; i < list.size(); i++)
            arr[i] = list.get(i);
        for(int i = 0; i < course.length; i++){
            visit = new boolean[list.size()];
            hashMap = new HashMap<>();
            temp = 0;
            dfs(0, 0, course[i], "", orders);
            ArrayList<String> alist = new ArrayList<>(hashMap.keySet());
            answer.addAll(alist);
        }
        String[] a = new String[answer.size()];
        for(int i = 0; i < a.length; i++)
            a[i] = answer.get(i);
        Arrays.sort(a);
        return a;
    }
    public void dfs(int start, int count, int max, String str, String[] orders){
        if(count == max){
            int t = check(str, orders);
            if(t < 2)
                return;
            if(temp == t){
                hashMap.put(str, t);
            }else if(temp < t){
                temp = t;
                hashMap.clear();
                hashMap.put(str, t);
            }
            return;
        }
        for(int i = start; i < arr.length; i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(i + 1, count + 1, max, str + arr[i], orders);
                visit[i] = false;
            }
        }
    }
public int check(String str, String[] orders){
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < str.length(); i++)
            list.add(str.charAt(i));
        Collections.sort(list);
        int size = 0;
        int index;
        for(int i = 0; i < orders.length; i++){
            index = 0;
            for(int j = 0; j < orders[i].length(); j++){
                if(index < list.size() && orders[i].charAt(j) == list.get(index)){
                    index++;
                    j = 0;
                }
            }
            if(index == list.size()){
                size++;
            }
        }
        return size;
    }
}