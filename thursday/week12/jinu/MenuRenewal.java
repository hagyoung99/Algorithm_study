package thursday.week12.jinu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 메뉴 리뉴얼(https://school.programmers.co.kr/learn/courses/30/lessons/72411)
public class MenuRenewal {

    static List<String> cases = new ArrayList<>();

    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        // Set 으로 단품메뉴가 뭐가있는지 메뉴를 넣고 중복제거
        Set<String> set = new HashSet<>();
        for (String data : orders) {
            String[] orders_sp = data.split("");
            for (String data2 : orders_sp) {
                set.add(data2);
            }
        }
        String[] Smenu = new String[set.size()];
        set.toArray(Smenu);
        boolean[] visited = new boolean[Smenu.length];
        for (int num : course) {

            cases.clear();

            List<String[]> count = new ArrayList<>();
            comb(Smenu, visited, 0, num);
            // 손님들이 코스 cases를 2명 이상이 주문햇는지 확인

            for (int i = 0; i < cases.size(); i++) {
                int cnt = 0;
                for (int j = 0; j < orders.length; j++) {
                    String[] temp = cases.get(i).split("");
                    boolean flag = true;
                    if (cases.get(i).length() > orders[j].length()) {
                        continue;
                    }
                    for (String data : temp) {
                        if (orders[j].contains(data)) {
                            flag = true;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                    if (flag == true) {
                        cnt++;
                    }
                }
                if (cnt >= 2) {
                    count.add(new String[] { cnt + "", cases.get(i) });
                }
            }
            // count가 없으면 생략, 있다면 제일 인기많은 후보 출력
            if (count.isEmpty()) {
                break;
            } else {
                Collections.sort(count, (a, b) -> Integer.parseInt(b[0]) - Integer.parseInt(a[0]));

                // 만약 Max주문횟수가 여러개있음을 가정하여 주문후보 출력
                String maxcount = count.get(0)[0];
                for (String[] data : count) {
                    if (maxcount.equals(data[0])) {
                        answer.add(data[1]);
                    }
                }
            }
        }
        // 사전순정렬
        Collections.sort(answer);

        return answer;
    }

    // 조합
    static public void comb(String[] Smenu, boolean[] visited, int start, int r) {
        if (r == 0) {
            print(Smenu, visited);
            return;
        } else {
            for (int i = start; i < Smenu.length; i++) {
                visited[i] = true;
                comb(Smenu, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }

    // 출력 함수: 손님들이 주문한메뉴로 가능한 조합을 모두넣음
    static void print(String[] Smenu, boolean[] visited) {
        String temp = "";
        for (int i = 0; i < Smenu.length; i++) {
            if (visited[i] == true) {
                temp += Smenu[i];
            }
        }
        cases.add(temp);
    }

}
