//스트링을 쓰려고 했지만, 이차원배열로 바꿈

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        String[][] arr = new String[N][2]; //개수 N 2차열 배열 생성

        for(int i=0;i<N;i++){
            arr[i][0]=sc.next();
            arr[i][1]=sc.next();
        }

        Arrays.sort(arr, new Comparator<String[]>() { //객체를 비교하기 위해 Arrays.sort에 Comparator를 구현
            public int compare(String[] o1, String[] o2) {
                return Integer.compare(Integer.parseInt(o1[0]),Integer.parseInt(o2[0])); //매개변수 [0] 인덱스 나이만 비교해주면 나이순, 같다면 입력받은 순정렬
            }
        });

        for(int i=0;i<N;i++){
            System.out.println(arr[i][0]+" "+arr[i][1]); //나이이름순으로 출력
        }

    }
}
