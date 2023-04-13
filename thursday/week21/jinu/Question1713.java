package thursday.week21.jinu;

import java.io.*;
import java.util.*;

// 1713번 후보 추천하기(https://www.acmicpc.net/problem/1713)
// n과 k를 입력받는다.
// ArrayList<Person> list를 선언하고, boolean 타입의 flag 배열을 선언한다. flag의 크기는 101이다.
// 학생 번호를 k번 입력받는다. 입력받을 때마다 아래 과정을 수행한다.
// 사진틀에 게시된 후보인 경우, list에서 그 후보를 찾아낸 다음, list에서 그 후보를 삭제하고 추천 수만 1 증가시킨 상태로 다시 list에 추가한다.
// 사진틀에 게시되지 않은 후보인 경우, 비어있는 사진틀이 없다면(list.size() == n), list를 정렬한 다음 가장 마지막 후보를 지우고 그 후보의 flag를 false로 변경한다.
// 사진틀에 게시되지 않은 후보인 경우, flag[photo] = true 로 변경하고 list에 새로운 후보를 추가한다.
// 5. list에 저장된 후보의 번호들을 ArrayList<Integer> tmp에 저장하고, tmp를 정렬한 다음 출력한다.
public class Question1713 {

    static class Person implements Comparable<Person> {
        int number;
        int like;
        int time; // 게시된 시간, 클수록 가장 최근에 게시됨

        public Person(int number, int like, int time) {
            this.number = number;
            this.like = like;
            this.time = time;
        }

        @Override
        public int compareTo(Person o) {
            if (this.like == o.like)
                return o.time - this.time; // 추천 수가 같으면 최근에 게시된 순으로 정렬
            else
                return o.like - this.like; // 추천 수 기준으로 내림차순
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        ArrayList<Person> list = new ArrayList<>();
        boolean[] flag = new boolean[101];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {

            int photo = Integer.parseInt(st.nextToken());

            // 사진틀에 게시된 후보인 경우
            if (flag[photo]) {
                // 후보의 추천수에 1을 더한다
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).number == photo) {
                        list.get(j).like += 1;
                        break;
                    }
                }
            } else {

                // 비어있는 사진틀이 없는 경우 사진 하나를 삭제한다
                if (list.size() == n) {
                    Collections.sort(list);
                    Person p = list.remove(n - 1);
                    flag[p.number] = false;
                }

                flag[photo] = true;
                list.add(new Person(photo, 0, i));
            }
        }

        // 사진틀에 게시된 후보의 번호를 tmp에 저장하고 tmp를 정렬한 다음 출력한다
        ArrayList<Integer> tmp = new ArrayList<>();
        for (Person p : list) {
            tmp.add(p.number);
        }
        Collections.sort(tmp);

        for (int i : tmp)
            bw.write(i + " ");

        bw.flush();
        bw.close();
        br.close();

    }
}