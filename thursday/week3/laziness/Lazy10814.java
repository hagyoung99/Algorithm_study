package laziness;

import java.io.*;
import java.util.*;

public class Lazy10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<Person> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i += 1) {
            String[] tmp = bufferedReader.readLine().split(" ");
            list.add(new Person(Integer.parseInt(tmp[0]), tmp[1]));
        }

        Collections.sort(list);

        for(Person p : list) System.out.println(p.toString());
    }

    static class Person implements Comparable<Person> {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }

        @Override
        public int compareTo(Person o) {
            return this.age - o.age;
        }
    }
}
